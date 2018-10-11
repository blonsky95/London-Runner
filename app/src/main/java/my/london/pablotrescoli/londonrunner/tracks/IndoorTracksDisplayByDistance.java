package my.london.pablotrescoli.londonrunner.tracks;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;

import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import my.london.pablotrescoli.londonrunner.R;
import my.london.pablotrescoli.londonrunner.main.LondonRunnerItem;
import my.london.pablotrescoli.londonrunner.main.LondonRunnerItemAdapter;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class IndoorTracksDisplayByDistance extends AppCompatActivity implements LocationListener {

    int SITE_ID = 2;

    protected LocationManager locationManager;
    ProgressDialog progress;

    double latDouble, lonDouble;
    boolean getFirstValue = false;

    boolean networkLocationEnabled=false;
    boolean gpsLocationEnabled=false;

    int NUMBER_OF_INDOOR_TRACKS = 6;
    Double METRES_PER_MILE = 1609.34;

    int[] fiveClosestDistancesIDs = new int[5];
    Double[] fiveClosestDistances = new Double[5];
    String[] fiveClosestDistStr = new String[5];
    Double[] distancesIndoorTrack = new Double[NUMBER_OF_INDOOR_TRACKS];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outdoortracks);
        setTitle("Closest indoor tracks");

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        setAndDesignToolbar();

        getLocation(); //location services have to be enabled to get to this activity, no need to check

    }

    private void getLocation() {
        showProgressDialog();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return; //if no permissions granted
            //permissions requested before intent to activity - should be granted both
        }
        networkLocationEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        gpsLocationEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (networkLocationEnabled) { //network provider is faster at expense of accuracy
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 100, this);
        }
        else {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,100,this);
        }
    }

    private void showProgressDialog() {
        progress = new ProgressDialog(this);
        progress.setTitle("Finding Location");
        progress.setMessage("Please wait"+"\n\nIf it is taking a long time, make sure your location works in google Maps first");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        progress.show();
    }

    @Override
    public void onLocationChanged(Location location) {
        progress.dismiss();
        latDouble = location.getLatitude();
        lonDouble = location.getLongitude();
        if (!getFirstValue) {
            getClosestTracks(latDouble, lonDouble);
            getFirstValue = true;
            locationManager.removeUpdates(this);

        }
    }

    private void getClosestTracks(double latDouble, double lonDouble) {

        distancesIndoorTrack = getDistanceFromEveryTrack(latDouble, lonDouble);

        Double[] sortedDistArray = new Double[distancesIndoorTrack.length];
        System.arraycopy(distancesIndoorTrack, 0, sortedDistArray, 0, distancesIndoorTrack.length);
        Arrays.sort(sortedDistArray);
        System.arraycopy(sortedDistArray, 0, fiveClosestDistances, 0, fiveClosestDistances.length);

        identifyFiveClosestTracks();//stores five closest distances in instanced fiveClosestDistStr String Array
        //stores the ID of the five closest distances in instanced fiveClosestIds int Array

        displayCorrespondingClosestTracks(fiveClosestDistancesIDs, fiveClosestDistStr);
    }


    private Double[] getDistanceFromEveryTrack(double latDouble, double lonDouble) {
        float[] distX = new float[1];
        String[] latCoordIndoorTracksStr = getResources().getStringArray(R.array.indoor_track_lat_coord);
        String[] lonCoordIndoorTracksStr = getResources().getStringArray(R.array.indoor_track_lon_coord);
        Double[] returnArray = new Double[NUMBER_OF_INDOOR_TRACKS];

        for (int i = 0; i < latCoordIndoorTracksStr.length; i++) {
            Double itemLatCoord = Double.parseDouble(latCoordIndoorTracksStr[i]);
            Double itemLonCoord = Double.parseDouble(lonCoordIndoorTracksStr[i]);
            Location.distanceBetween(latDouble, lonDouble, itemLatCoord, itemLonCoord, distX);
            returnArray[i] = (double) metresToMiles(distX[0]);
        }
        return returnArray;
    }

    private Object metresToMiles(float distX) {
        return distX / METRES_PER_MILE;
    }

    private void identifyFiveClosestTracks() {
        Double[] sortedDist = new Double[NUMBER_OF_INDOOR_TRACKS];

        System.arraycopy(distancesIndoorTrack, 0, sortedDist, 0, distancesIndoorTrack.length);
        Arrays.sort(sortedDist);
        System.arraycopy(sortedDist, 0, fiveClosestDistances, 0, fiveClosestDistances.length);

        String pattern = "###.#";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);

        for (int i = 0; i < distancesIndoorTrack.length; i++) {
            for (int k = 0; k < fiveClosestDistances.length; k++)
                if (distancesIndoorTrack[i].equals(fiveClosestDistances[k])) {
                    fiveClosestDistancesIDs[k] = i;
                    fiveClosestDistStr[k] = decimalFormat.format(fiveClosestDistances[k]) + " miles away";
                }
        }
    }


    private void displayCorrespondingClosestTracks(int[] fiveClosestIds, String[] fiveclosestDistStr) {

        final ArrayList<LondonRunnerItem> items = new ArrayList<>();

        String[] itemIndoorName = getResources().getStringArray(R.array.indoor_track_name);
        String[] itemIndoorPicURL = getResources().getStringArray(R.array.indoor_track_picURL);

        for (int i = 0; i < fiveClosestDistances.length; i++) {
            int ID = fiveClosestIds[i];
            items.add(new LondonRunnerItem(itemIndoorName[ID], fiveclosestDistStr[i], itemIndoorPicURL[ID]));
        }

        setAdapter(items);
    }

    private void setAdapter(ArrayList<LondonRunnerItem> itemsList) {
        LondonRunnerItemAdapter adapter = new LondonRunnerItemAdapter(this, itemsList, SITE_ID, fiveClosestDistancesIDs);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }


    @Override
    protected void onPause() {
        super.onPause();
        if (progress!=null&&progress.isShowing()) {
            locationManager.removeUpdates(this);
            progress.dismiss();
            finish();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.list_menu3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_1:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                builder.setMessage(R.string.info_distance);
                builder.setCancelable(true);
                builder.show();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

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

