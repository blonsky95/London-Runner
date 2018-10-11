package com.example.pablotrescoli.londonrunner.tracks;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;

import com.example.pablotrescoli.londonrunner.R;
import com.example.pablotrescoli.londonrunner.main.LondonRunnerItem;
import com.example.pablotrescoli.londonrunner.main.LondonRunnerItemAdapter;

import java.util.ArrayList;

public class OutdoorTracksDisplay extends AppCompatActivity {

    int SITE_ID = 1;

    final int FINE_LOCATION_PERMISSION_GRANTED = 111;
    final int COARSE_LOCATION_PERMISSION_GRANTED = 112;

    boolean PERMISSION_FINE_LOCATION = false;
    boolean PERMISSION_COARSE_LOCATION = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outdoortracks);
        setTitle("Outdoor tracks");

        setAndDesignToolbar();


        final ArrayList<LondonRunnerItem> items = new ArrayList<>();

        String[] itemOutdoorName = getResources().getStringArray(R.array.outdoor_track_name);
        String[] itemOutdoorAdress = getResources().getStringArray(R.array.outdoor_track_adress);
        String[] itemOutdoorPicURL = getResources().getStringArray(R.array.outdoor_track_picURL);

        for (int i = 0; i < itemOutdoorName.length; i++) {
            items.add(new LondonRunnerItem(itemOutdoorName[i], itemOutdoorAdress[i], itemOutdoorPicURL[i]));
        }

        int[] fiveClosestIds = {-1};

        LondonRunnerItemAdapter adapter = new LondonRunnerItemAdapter(this, items, SITE_ID, fiveClosestIds);
        ListView listView = findViewById(R.id.list);
//
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

                        int permissionCheck1 = ContextCompat.checkSelfPermission(OutdoorTracksDisplay.this,
                                Manifest.permission.ACCESS_FINE_LOCATION);
                        if (permissionCheck1 == PackageManager.PERMISSION_DENIED) {
                            //ask permission
                            ActivityCompat.requestPermissions(OutdoorTracksDisplay.this,
                                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                    FINE_LOCATION_PERMISSION_GRANTED);
                        }
                        if (permissionCheck1 == PackageManager.PERMISSION_GRANTED) {
                            PERMISSION_FINE_LOCATION = true;

                        }
                        int permissionCheck2 = ContextCompat.checkSelfPermission(OutdoorTracksDisplay.this,
                                Manifest.permission.ACCESS_COARSE_LOCATION);
                        if (permissionCheck2 == PackageManager.PERMISSION_DENIED) {
                            //ask permission
                            ActivityCompat.requestPermissions(OutdoorTracksDisplay.this,
                                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                                    COARSE_LOCATION_PERMISSION_GRANTED);
                        }
                        if (permissionCheck2 == PackageManager.PERMISSION_GRANTED) {
                            PERMISSION_COARSE_LOCATION = true;

                        }
                        if (PERMISSION_COARSE_LOCATION || PERMISSION_FINE_LOCATION) {
                            displayClosestOutdoorTracks();
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

                return super.onOptionsItemSelected(item);

        }

    }

    public void displayClosestOutdoorTracks() {
        Intent refreshScreen = new Intent(OutdoorTracksDisplay.this, OutdoorTracksDisplayByDistance.class);
        startActivity(refreshScreen);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case FINE_LOCATION_PERMISSION_GRANTED: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    displayClosestOutdoorTracks();

                }

            }
            break;
            case COARSE_LOCATION_PERMISSION_GRANTED: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    displayClosestOutdoorTracks();

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
