package my.london.pablotrescoli.londonrunner.tracks;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import my.london.pablotrescoli.londonrunner.R;
import my.london.pablotrescoli.londonrunner.main.LondonRunnerItem;
import my.london.pablotrescoli.londonrunner.main.LondonRunnerItemAdapter;

import java.util.ArrayList;

import my.london.pablotrescoli.londonrunner.main.LondonRunnerItem;
import my.london.pablotrescoli.londonrunner.main.LondonRunnerItemAdapter;

public class IndoorTracksDisplay extends AppCompatActivity {

    int SITE_ID = 2;

    final int FINE_LOCATION_PERMISSION_GRANTED = 111;
    final int COARSE_LOCATION_PERMISSION_GRANTED = 112;

    boolean PERMISSION_FINE_LOCATION = false;
    boolean PERMISSION_COARSE_LOCATION = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outdoortracks);
        setTitle("Indoor tracks");

        setAndDesignToolbar();

        final ArrayList<LondonRunnerItem> items = new ArrayList<>();

        String[] itemIndoorName = getResources().getStringArray(R.array.indoor_track_name);
        String[] itemIndoorAdress = getResources().getStringArray(R.array.indoor_track_address);
        String[] itemIndoorPicURL = getResources().getStringArray(R.array.indoor_track_picURL);


        for (int i = 0; i < itemIndoorName.length; i++) {
            items.add(new LondonRunnerItem(itemIndoorName[i], itemIndoorAdress[i], itemIndoorPicURL[i]));
        }

        int[] fiveClosestIds = {-1};

        LondonRunnerItemAdapter adapter = new LondonRunnerItemAdapter(this, items, SITE_ID, fiveClosestIds);
        ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.list_menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_1:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);


                builder.setMessage("Locate the closest tracks to your location?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        int permissionCheck1 = ContextCompat.checkSelfPermission(IndoorTracksDisplay.this,
                                Manifest.permission.ACCESS_FINE_LOCATION);
                        if (permissionCheck1 == PackageManager.PERMISSION_DENIED) {
                            //ask permission
                            ActivityCompat.requestPermissions(IndoorTracksDisplay.this,
                                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                    FINE_LOCATION_PERMISSION_GRANTED);
                        }
                        if (permissionCheck1 == PackageManager.PERMISSION_GRANTED) {
                            PERMISSION_FINE_LOCATION = true;

                        }
                        int permissionCheck2 = ContextCompat.checkSelfPermission(IndoorTracksDisplay.this,
                                Manifest.permission.ACCESS_COARSE_LOCATION);
                        if (permissionCheck2 == PackageManager.PERMISSION_DENIED) {
                            //ask permission
                            ActivityCompat.requestPermissions(IndoorTracksDisplay.this,
                                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                                    COARSE_LOCATION_PERMISSION_GRANTED);
                        }
                        if (permissionCheck2 == PackageManager.PERMISSION_GRANTED) {
                            PERMISSION_COARSE_LOCATION = true;

                        }
                        if (PERMISSION_COARSE_LOCATION || PERMISSION_FINE_LOCATION) {
                            checkLocationServicesAndLoadClosestTracks();
                        }

                    }


                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.show();
                return true;


            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }

    }

    private void checkLocationServicesAndLoadClosestTracks() {
        boolean locationServicesEnabledBoolean = areLocationServicesEnabled();

        if (locationServicesEnabledBoolean) {
            displayClosestIndoorTracks();
        } else {
            sendUserToLocationSettings();
        }
    }

    private boolean areLocationServicesEnabled() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        boolean networkLocationEnabled = false;
        boolean gpsLocationEnabled = false;

        if (locationManager != null) {
            networkLocationEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
            gpsLocationEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        }
        return networkLocationEnabled || gpsLocationEnabled;
    }

    private void sendUserToLocationSettings() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Location services have to be activated");
        builder.setCancelable(false);
        builder.setPositiveButton("Location settings", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Intent intent = new Intent(
                        Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
                finish();

            }
        });

        builder.show();
    }

    public void displayClosestIndoorTracks() {
        Intent refreshScreen = new Intent(IndoorTracksDisplay.this, IndoorTracksDisplayByDistance.class);
        startActivity(refreshScreen);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case FINE_LOCATION_PERMISSION_GRANTED: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    checkLocationServicesAndLoadClosestTracks();

                }

            }
            break;
            case COARSE_LOCATION_PERMISSION_GRANTED: {
                if (grantResults.length > 0
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    checkLocationServicesAndLoadClosestTracks();
                }
            }
            break;

        }
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void setAndDesignToolbar() {
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            myToolbar.setBackgroundColor(getResources().getColor(R.color.actionbar_bg));
            myToolbar.setTitleTextColor(getResources().getColor(R.color.white)); //
            myToolbar.setNavigationIcon(R.drawable.back_icon);
        }
    }

}
