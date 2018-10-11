package com.example.pablotrescoli.londonrunner.tracks;

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

import com.example.pablotrescoli.londonrunner.R;
import com.example.pablotrescoli.londonrunner.main.LondonRunnerItem;
import com.example.pablotrescoli.londonrunner.main.LondonRunnerItemAdapter;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class OutdoorTracksDisplayByDistance extends AppCompatActivity implements LocationListener {
    int SITE_ID = 1;
    protected LocationManager locationManager;
    ProgressDialog progress;

    double latDouble, lonDouble;
    boolean getFirstValue = false;

    int NUMBER_OF_OUTDOOR_TRACKS = 34;
    Double METRES_PER_MILE = 1609.34;

    int[] fiveClosestIds = new int[5];
    Double[] fiveclosestDistances = new Double[5];
    String[] fiveClosestDistStr = new String[5];
    Double[] distancesOutdoorTrack = new Double[NUMBER_OF_OUTDOOR_TRACKS];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outdoortracks);
        setTitle("Closest outdoor tracks");

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        setAndDesignToolbar();

        requestLocationIfDisabled(); //Consider making a new class for this functionality

    }

    private void requestLocationIfDisabled() {
        if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            getLocation();
        } else {

            sendUserToLocationSettings();

        }
    }

    private void getLocation() {
        progress = new ProgressDialog(this);
        progress.setTitle("Finding Location");
        progress.setMessage("Please wait");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        progress.show();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
    }

    private void sendUserToLocationSettings() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("GPS has to be activated");
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


        distancesOutdoorTrack = getDistanceFromEveryTrack(latDouble, lonDouble);

        identifyFiveClosestTracks();//stores five closest distances in fiveClosestDistStr String Array
        //stores the ID of the five closest distances in fiveClosestIds int Array

        displayCorrespondingClosestTracks(fiveClosestIds, fiveClosestDistStr);
    }

    private Double[] getDistanceFromEveryTrack(double latDouble, double lonDouble) {
        float[] distX = new float[1];
        String[] latCoordOutdoorTracksStr = getResources().getStringArray(R.array.outdoor_track_lat_coord);
        String[] lonCoordOutdoorTracksStr = getResources().getStringArray(R.array.outdoor_track_lon_coord);
        Double[] returnArray = new Double[NUMBER_OF_OUTDOOR_TRACKS];

        for (int i = 0; i < latCoordOutdoorTracksStr.length; i++) {
            Double itemLatCoord = Double.parseDouble(latCoordOutdoorTracksStr[i]);
            Double itemLonCoord = Double.parseDouble(lonCoordOutdoorTracksStr[i]);
            Location.distanceBetween(latDouble, lonDouble, itemLatCoord, itemLonCoord, distX);
            returnArray[i] = (double) metresToMiles(distX[0]);
        }
        return returnArray;
    }

    private Object metresToMiles(float distX) {
        return distX / METRES_PER_MILE;
    }


    private void identifyFiveClosestTracks() {
        Double[] sortedDist = new Double[NUMBER_OF_OUTDOOR_TRACKS];

        System.arraycopy(distancesOutdoorTrack, 0, sortedDist, 0, distancesOutdoorTrack.length);
        Arrays.sort(sortedDist);
        System.arraycopy(sortedDist, 0, fiveclosestDistances, 0, fiveclosestDistances.length);

        String pattern = "###.#";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);

        for (int i = 0; i < distancesOutdoorTrack.length; i++) {
            for (int k = 0; k < fiveclosestDistances.length; k++)
                if (distancesOutdoorTrack[i].equals(fiveclosestDistances[k])) {
                    fiveClosestIds[k] = i;
                    fiveClosestDistStr[k] = decimalFormat.format(fiveclosestDistances[k]) + " miles away";
                }
        }
    }

    private void displayCorrespondingClosestTracks(int[] fiveClosestIds, String[] fiveClosestDistStr) {

        final ArrayList<LondonRunnerItem> items = new ArrayList<>();

        String[] itemOutdoorName = getResources().getStringArray(R.array.outdoor_track_name);
        String[] itemOutdoorPicURL = getResources().getStringArray(R.array.outdoor_track_picURL);

        for (int i = 0; i < fiveclosestDistances.length; i++) {
            int ID = fiveClosestIds[i];
            items.add(new LondonRunnerItem(itemOutdoorName[ID], fiveClosestDistStr[i], itemOutdoorPicURL[ID]));
        }

        setAdapter(items);

    }

    private void setAdapter(ArrayList<LondonRunnerItem> itemsList) {
        LondonRunnerItemAdapter adapter = new LondonRunnerItemAdapter(this, itemsList, SITE_ID, fiveClosestIds);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        locationManager.removeUpdates(this);
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
