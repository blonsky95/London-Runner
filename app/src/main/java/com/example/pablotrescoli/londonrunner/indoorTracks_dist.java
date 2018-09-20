package com.example.pablotrescoli.londonrunner;

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
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class indoorTracks_dist extends AppCompatActivity implements LocationListener {
    int SITE_ID = 2;
    protected LocationManager locationManager;
    protected LocationListener locationListener;
    protected Context context;
    protected String latitude, longitude;
    ProgressDialog progress;

    double latDouble, lonDouble;
    boolean getFirstValue = false;
    int[] fiveClosestIds = new int[5];
    Double[] fiveclosestDist = new Double[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outdoortracks);
        setTitle("Closest outdoor tracks");

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            progress = new ProgressDialog(this);
            progress.setTitle("Finding Location");
            progress.setMessage("Please wait");
            progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
            progress.show();

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
        } else {
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
    public void onLocationChanged(Location location) {
        progress.dismiss();
        latDouble = location.getLatitude();
        lonDouble = location.getLongitude();
        if (!getFirstValue) {
            calculateDistances(latDouble, lonDouble);
            getFirstValue = true;
            locationManager.removeUpdates(this);

        }
        Log.e("LAT AND LON", latDouble + " " + lonDouble);
    }

    @Override
    protected void onPause() {
        super.onPause();
        locationManager.removeUpdates(this);
    }

    private void calculateDistances(double latDouble, double lonDouble) {
        double[][] latlonArray = new double[6][3];
        float[] distX = new float[1];


        latlonArray[0][1] = 51.6307482;
        latlonArray[0][2] = -0.0396025;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[0][1], latlonArray[0][2], distX);
        latlonArray[0][0] = distX[0] / 1609.34;

        latlonArray[1][1] = 51.4210481;
        latlonArray[1][2] = -0.0694977;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[1][1], latlonArray[1][2], distX);
        latlonArray[1][0] = distX[0] / 1609.34;

        latlonArray[2][1] = 51.3840118;
        latlonArray[2][2] = -0.1831419;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[2][1], latlonArray[2][2], distX);
        latlonArray[2][0] = distX[0] / 1609.34;

        latlonArray[3][1] = 51.5402145;
        latlonArray[3][2] = -0.2332427;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[3][1], latlonArray[3][2], distX);
        latlonArray[3][0] = distX[0] / 1609.34;

        latlonArray[4][1] = 51.6033929;
        latlonArray[4][2] = -0.2257317;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[4][1], latlonArray[4][2], distX);
        latlonArray[4][0] = distX[0] / 1609.34;

        latlonArray[5][1] = 51.5300881;
        latlonArray[5][2] = -0.4665948;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[5][1], latlonArray[5][2], distX);
        latlonArray[5][0] = distX[0] / 1609.34;


        Double[] sortedDist = new Double[6];

        for (int i = 0; i < latlonArray.length; i++) {
            sortedDist[i] = latlonArray[i][0];
        }
        Arrays.sort(sortedDist);
        System.arraycopy(sortedDist, 0, fiveclosestDist, 0, fiveclosestDist.length);

        for (int i = 0; i < latlonArray.length; i++) {
            for (int k = 0; k < fiveclosestDist.length; k++)
                if (latlonArray[i][0] == fiveclosestDist[k]) {
                    fiveClosestIds[k] = i;
                }
        }

        setNewLayout(fiveClosestIds, fiveclosestDist);
    }

    private void setNewLayout(int[] fiveClosestIds, Double[] fiveclosestDist) {

        final ArrayList<runningItem> items = new ArrayList<runningItem>();
        String milesAway;

        String pattern = "###.#";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        for (int i = 0; i < fiveclosestDist.length; i++) {
            int ID = fiveClosestIds[i] + 1;
            switch (ID) {
                case 1:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type2_9_name, R.string.type2_9_address, milesAway, R.string.type2_9_picURL));
                    break;
                case 2:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type2_18_name, R.string.type2_18_address, milesAway, R.string.type2_18_picURL));
                    break;
                case 3:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type2_20_name, R.string.type2_20_address, milesAway, R.string.type2_20_picURL));
                    break;
                case 4:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type2_25_name, R.string.type2_25_address, milesAway, R.string.type2_25_picURL));
                    break;
                case 5:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type2_26_name, R.string.type2_26_address, milesAway, R.string.type2_26_picURL));
                    break;
                case 6:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type2_32_name, R.string.type2_32_address, milesAway, R.string.type2_32_picURL));
                    break;

            }


        }

        runningItemAdapter adapter = new runningItemAdapter(this, items, R.color.transp_bg, SITE_ID, fiveClosestIds);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
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
}

