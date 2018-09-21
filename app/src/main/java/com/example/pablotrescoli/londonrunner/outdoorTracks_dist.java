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

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class outdoorTracks_dist extends AppCompatActivity implements LocationListener {
    int SITE_ID = 1;
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
        double[][] latlonArray = new double[33][3];
        float[] distX = new float[1];


        latlonArray[0][1] = 51.5192054;
        latlonArray[0][2] = -0.0321641;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[0][1], latlonArray[0][2], distX);
        latlonArray[0][0] = distX[0] / 1609.34;

        latlonArray[1][1] = 51.5350378;
        latlonArray[1][2] = -0.1625312;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[1][1], latlonArray[1][2], distX);
        latlonArray[1][0] = distX[0] / 1609.34;

        latlonArray[2][1] = 51.4810805;
        latlonArray[2][2] = -0.1536341;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[2][1], latlonArray[2][2], distX);
        latlonArray[2][0] = distX[0] / 1609.34;

        latlonArray[3][1] = 51.557101;
        latlonArray[3][2] = -0.1578247;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[3][1], latlonArray[3][2], distX);
        latlonArray[3][0] = distX[0] / 1609.34;

        latlonArray[4][1] = 51.5715205;
        latlonArray[4][2] = -0.1032436;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[4][1], latlonArray[4][2], distX);
        latlonArray[4][0] = distX[0] / 1609.34;

        latlonArray[5][1] = 51.5321241;
        latlonArray[5][2] = -0.1925841;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[5][1], latlonArray[5][2], distX);
        latlonArray[5][0] = distX[0] / 1609.34;

        latlonArray[6][1] = 51.539136;
        latlonArray[6][2] = -0.032339;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[6][1], latlonArray[6][2], distX);
        latlonArray[6][0] = distX[0] / 1609.34;

        latlonArray[7][1] = 51.6046666;
        latlonArray[7][2] = -0.1025875;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[7][1], latlonArray[7][2], distX);
        latlonArray[7][0] = distX[0] / 1609.34;

        latlonArray[8][1] = 51.6307482;
        latlonArray[8][2] = -0.0396025;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[8][1], latlonArray[8][2], distX);
        latlonArray[8][0] = distX[0] / 1609.34;

        latlonArray[9][1] = 51.658936;
        latlonArray[9][2] = -0.0659287;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[9][1], latlonArray[9][2], distX);
        latlonArray[9][0] = distX[0] / 1609.34;

        latlonArray[10][1] = 51.593435;
        latlonArray[10][2] = -0.0165817;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[10][1], latlonArray[10][2], distX);
        latlonArray[10][0] = distX[0] / 1609.34;

        latlonArray[11][1] = 51.6055422;
        latlonArray[11][2] = 0.0481952;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[11][1], latlonArray[11][2], distX);
        latlonArray[11][0] = distX[0] / 1609.34;

        latlonArray[12][1] = 51.518625;
        latlonArray[12][2] = 0.0332733;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[12][1], latlonArray[12][2], distX);
        latlonArray[12][0] = distX[0] / 1609.34;

        latlonArray[13][1] = 51.4540192;
        latlonArray[13][2] = 0.0257354;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[13][1], latlonArray[13][2], distX);
        latlonArray[13][0] = distX[0] / 1609.34;

        latlonArray[14][1] = 51.4499611;
        latlonArray[14][2] = -0.0243766;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[14][1], latlonArray[14][2], distX);
        latlonArray[14][0] = distX[0] / 1609.34;

        latlonArray[15][1] = 51.3866764;
        latlonArray[15][2] = 0.0193497;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[15][1], latlonArray[15][2], distX);
        latlonArray[15][0] = distX[0] / 1609.34;

        latlonArray[16][1] = 51.3935487;
        latlonArray[16][2] = -0.0628126;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[16][1], latlonArray[16][2], distX);
        latlonArray[16][0] = distX[0] / 1609.34;

        latlonArray[17][1] = 51.4210481;
        latlonArray[17][2] = -0.0694977;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[17][1], latlonArray[17][2], distX);
        latlonArray[17][0] = distX[0] / 1609.34;

        latlonArray[18][1] = 51.4302019;
        latlonArray[18][2] = -0.1484613;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[18][1], latlonArray[18][2], distX);
        latlonArray[18][0] = distX[0] / 1609.34;

        latlonArray[19][1] = 51.3840118;
        latlonArray[19][2] = -0.1831419;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[19][1], latlonArray[19][2], distX);
        latlonArray[19][0] = distX[0] / 1609.34;

        latlonArray[20][1] = 51.4383241;
        latlonArray[20][2] = -0.2102645;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[20][1], latlonArray[20][2], distX);
        latlonArray[20][0] = distX[0] / 1609.34;

        latlonArray[21][1] = 51.4054642;
        latlonArray[21][2] = -0.2835909;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[21][1], latlonArray[21][2], distX);
        latlonArray[21][0] = distX[0] / 1609.34;

        latlonArray[22][1] = 51.475881;
        latlonArray[22][2] = -0.2320657;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[22][1], latlonArray[22][2], distX);
        latlonArray[22][0] = distX[0] / 1609.34;

        latlonArray[23][1] = 51.5192317;
        latlonArray[23][2] = -0.2375686;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[23][1], latlonArray[23][2], distX);
        latlonArray[23][0] = distX[0] / 1609.34;

        latlonArray[24][1] = 51.5402145;
        latlonArray[24][2] = -0.2332427;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[24][1], latlonArray[24][2], distX);
        latlonArray[24][0] = distX[0] / 1609.34;

        latlonArray[25][1] = 51.6033929;
        latlonArray[25][2] = -0.2257317;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[25][1], latlonArray[25][2], distX);
        latlonArray[25][0] = distX[0] / 1609.34;

        latlonArray[26][1] = 51.6104278;
        latlonArray[26][2] = -0.3556106;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[26][1], latlonArray[26][2], distX);
        latlonArray[26][0] = distX[0] / 1609.34;

        latlonArray[27][1] = 51.5324251;
        latlonArray[27][2] = -0.3396591;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[27][1], latlonArray[27][2], distX);
        latlonArray[27][0] = distX[0] / 1609.34;

        latlonArray[28][1] = 51.4819909;
        latlonArray[28][2] = -0.3407586;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[28][1], latlonArray[28][2], distX);
        latlonArray[28][0] = distX[0] / 1609.34;

        latlonArray[29][1] = 51.435851;
        latlonArray[29][2] = -0.333816;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[29][1], latlonArray[29][2], distX);
        latlonArray[29][0] = distX[0] / 1609.34;

        latlonArray[30][1] = 51.5531889;
        latlonArray[30][2] = -0.4687728;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[30][1], latlonArray[30][2], distX);
        latlonArray[30][0] = distX[0] / 1609.34;

        latlonArray[31][1] = 51.5300881;
        latlonArray[31][2] = -0.4665948;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[31][1], latlonArray[31][2], distX);
        latlonArray[31][0] = distX[0] / 1609.34;

        latlonArray[32][1] = 51.5567495;
        latlonArray[32][2] = 0.2376285;
        Location.distanceBetween(latDouble, lonDouble, latlonArray[32][1], latlonArray[32][2], distX);
        latlonArray[32][0] = distX[0] / 1609.34;

        Double[] sortedDist = new Double[33];

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
                    milesAway =decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type1_1_name, R.string.type1_1_address, milesAway, R.string.type1_1_picURL));
                    break;
                case 2:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type1_2_name, R.string.type1_2_address, milesAway, R.string.type1_2_picURL));
                    break;
                case 3:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type1_3_name, R.string.type1_3_address, milesAway, R.string.type1_3_picURL));
                    break;
                case 4:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type1_4_name, R.string.type1_4_address, milesAway, R.string.type1_4_picURL));
                    break;
                case 5:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type1_5_name, R.string.type1_5_address, milesAway, R.string.type1_5_picURL));
                    break;
                case 6:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type1_6_name, R.string.type1_6_address, milesAway, R.string.type1_6_picURL));
                    break;
                case 7:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type1_7_name, R.string.type1_7_address, milesAway, R.string.type1_7_picURL));
                    break;
                case 8:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type1_8_name, R.string.type1_8_address, milesAway, R.string.type1_8_picURL));
                    break;
                case 9:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type1_9_name, R.string.type1_9_address, milesAway, R.string.type1_9_picURL));
                    break;
                case 10:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type1_10_name, R.string.type1_10_address, milesAway, R.string.type1_10_picURL));
                    break;
                case 11:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type1_11_name, R.string.type1_11_address, milesAway, R.string.type1_11_picURL));
                    break;
                case 12:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type1_12_name, R.string.type1_12_address, milesAway, R.string.type1_12_picURL));
                    break;
                case 13:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type1_13_name, R.string.type1_13_address, milesAway, R.string.type1_13_picURL));
                    break;
                case 14:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type1_14_name, R.string.type1_14_address, milesAway, R.string.type1_14_picURL));
                    break;
                case 15:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type1_15_name, R.string.type1_15_address, milesAway, R.string.type1_15_picURL));
                    break;
                case 16:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type1_16_name, R.string.type1_16_address, milesAway, R.string.type1_16_picURL));
                    break;
                case 17:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type1_17_name, R.string.type1_17_address, milesAway, R.string.type1_17_picURL));
                    break;
                case 18:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type1_18_name, R.string.type1_18_address, milesAway, R.string.type1_18_picURL));
                    break;
                case 19:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type1_19_name, R.string.type1_19_address, milesAway, R.string.type1_19_picURL));
                    break;
                case 20:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type1_20_name, R.string.type1_20_address, milesAway, R.string.type1_20_picURL));
                    break;
                case 21:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type1_21_name, R.string.type1_21_address, milesAway, R.string.type1_21_picURL));
                    break;
                case 22:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type1_22_name, R.string.type1_22_address, milesAway, R.string.type1_22_picURL));
                    break;
                case 23:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type1_23_name, R.string.type1_23_address, milesAway, R.string.type1_23_picURL));
                    break;
                case 24:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type1_24_name, R.string.type1_24_address, milesAway, R.string.type1_24_picURL));
                    break;
                case 25:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type1_25_name, R.string.type1_25_address, milesAway, R.string.type1_25_picURL));
                    break;
                case 26:
                    milesAway =decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type1_26_name, R.string.type1_26_address, milesAway, R.string.type1_26_picURL));
                    break;
                case 27:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type1_27_name, R.string.type1_27_address, milesAway, R.string.type1_27_picURL));
                    break;
                case 28:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type1_28_name, R.string.type1_28_address, milesAway, R.string.type1_28_picURL));
                    break;
                case 29:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type1_29_name, R.string.type1_29_address, milesAway, R.string.type1_29_picURL));
                    break;
                case 30:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type1_30_name, R.string.type1_30_address, milesAway, R.string.type1_30_picURL));
                    break;
                case 31:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type1_31_name, R.string.type1_31_address, milesAway, R.string.type1_31_picURL));
                    break;
                case 32:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type1_32_name, R.string.type1_32_address, milesAway, R.string.type1_32_picURL));
                    break;
                case 33:
                    milesAway = decimalFormat.format(fiveclosestDist[i]) + " miles away";
                    items.add(new runningItem(R.string.type1_33_name, R.string.type1_33_address, milesAway, R.string.type1_33_picURL));
                    break;
            }


        }

        runningItemAdapter adapter = new runningItemAdapter(this, items, R.color.transp_bg, SITE_ID,fiveClosestIds);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
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
}
