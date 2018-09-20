package com.example.pablotrescoli.londonrunner;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;

public class outdoorTracks extends AppCompatActivity {

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

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);


        final ArrayList<runningItem> items = new ArrayList<runningItem>();
        items.add(new runningItem(R.string.type1_1_name, R.string.type1_1_address, R.string.type1_1_price2, R.string.type1_1_picURL));
        items.add(new runningItem(R.string.type1_2_name, R.string.type1_2_address, R.string.type1_2_price2, R.string.type1_2_picURL));
        items.add(new runningItem(R.string.type1_3_name, R.string.type1_3_address, R.string.type1_3_price2, R.string.type1_3_picURL));
        items.add(new runningItem(R.string.type1_4_name, R.string.type1_4_address, R.string.type1_4_price2, R.string.type1_4_picURL));
        items.add(new runningItem(R.string.type1_5_name, R.string.type1_5_address, R.string.type1_5_price2, R.string.type1_5_picURL));
        items.add(new runningItem(R.string.type1_6_name, R.string.type1_6_address, R.string.type1_6_price2, R.string.type1_6_picURL));
        items.add(new runningItem(R.string.type1_7_name, R.string.type1_7_address, R.string.type1_7_price2, R.string.type1_7_picURL));
        items.add(new runningItem(R.string.type1_8_name, R.string.type1_8_address, R.string.type1_8_price2, R.string.type1_8_picURL));
        items.add(new runningItem(R.string.type1_9_name, R.string.type1_9_address, R.string.type1_9_price2, R.string.type1_9_picURL));
        items.add(new runningItem(R.string.type1_10_name, R.string.type1_10_address, R.string.type1_10_price2, R.string.type1_10_picURL));
        items.add(new runningItem(R.string.type1_11_name, R.string.type1_11_address, R.string.type1_11_price2, R.string.type1_11_picURL));
        items.add(new runningItem(R.string.type1_12_name, R.string.type1_12_address, R.string.type1_12_price2, R.string.type1_12_picURL));
        items.add(new runningItem(R.string.type1_13_name, R.string.type1_13_address, R.string.type1_13_price2, R.string.type1_13_picURL));
        items.add(new runningItem(R.string.type1_14_name, R.string.type1_14_address, R.string.type1_14_price2, R.string.type1_14_picURL));
        items.add(new runningItem(R.string.type1_15_name, R.string.type1_15_address, R.string.type1_15_price2, R.string.type1_15_picURL));
        items.add(new runningItem(R.string.type1_16_name, R.string.type1_16_address, R.string.type1_16_price2, R.string.type1_16_picURL));
        items.add(new runningItem(R.string.type1_17_name, R.string.type1_17_address, R.string.type1_17_price2, R.string.type1_17_picURL));
        items.add(new runningItem(R.string.type1_18_name, R.string.type1_18_address, R.string.type1_18_price2, R.string.type1_18_picURL));
        items.add(new runningItem(R.string.type1_19_name, R.string.type1_19_address, R.string.type1_19_price2, R.string.type1_19_picURL));
        items.add(new runningItem(R.string.type1_20_name, R.string.type1_20_address, R.string.type1_20_price2, R.string.type1_20_picURL));
        items.add(new runningItem(R.string.type1_21_name, R.string.type1_21_address, R.string.type1_21_price2, R.string.type1_21_picURL));
        items.add(new runningItem(R.string.type1_22_name, R.string.type1_22_address, R.string.type1_22_price2, R.string.type1_22_picURL));
        items.add(new runningItem(R.string.type1_23_name, R.string.type1_23_address, R.string.type1_23_price2, R.string.type1_23_picURL));
        items.add(new runningItem(R.string.type1_24_name, R.string.type1_24_address, R.string.type1_24_price2, R.string.type1_24_picURL));
        items.add(new runningItem(R.string.type1_25_name, R.string.type1_25_address, R.string.type1_25_price2, R.string.type1_25_picURL));
        items.add(new runningItem(R.string.type1_26_name, R.string.type1_26_address, R.string.type1_26_price2, R.string.type1_26_picURL));
        items.add(new runningItem(R.string.type1_27_name, R.string.type1_27_address, R.string.type1_27_price2, R.string.type1_27_picURL));
        items.add(new runningItem(R.string.type1_28_name, R.string.type1_28_address, R.string.type1_28_price2, R.string.type1_28_picURL));
        items.add(new runningItem(R.string.type1_29_name, R.string.type1_29_address, R.string.type1_29_price2, R.string.type1_29_picURL));
        items.add(new runningItem(R.string.type1_30_name, R.string.type1_30_address, R.string.type1_30_price2, R.string.type1_30_picURL));
        items.add(new runningItem(R.string.type1_31_name, R.string.type1_31_address, R.string.type1_31_price2, R.string.type1_31_picURL));
        items.add(new runningItem(R.string.type1_32_name, R.string.type1_32_address, R.string.type1_32_price2, R.string.type1_32_picURL));
        items.add(new runningItem(R.string.type1_33_name, R.string.type1_33_address, R.string.type1_33_price2, R.string.type1_33_picURL));

        int[] fiveClosestIds = {-1};


        runningItemAdapter adapter = new runningItemAdapter(this, items, R.color.transp_bg, SITE_ID,fiveClosestIds);
        ListView listView = (ListView) findViewById(R.id.list);
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


                builder.setMessage("GET CLOSEST TRACKS?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        int permissionCheck1 = ContextCompat.checkSelfPermission(outdoorTracks.this,
                                Manifest.permission.ACCESS_FINE_LOCATION);
                        if (permissionCheck1 == PackageManager.PERMISSION_DENIED) {
                            //ask permission
                            ActivityCompat.requestPermissions(outdoorTracks.this,
                                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                    FINE_LOCATION_PERMISSION_GRANTED);
                        }
                        if (permissionCheck1 == PackageManager.PERMISSION_GRANTED) {
                            PERMISSION_FINE_LOCATION = true;

                        }
                        int permissionCheck2 = ContextCompat.checkSelfPermission(outdoorTracks.this,
                                Manifest.permission.ACCESS_COARSE_LOCATION);
                        if (permissionCheck2 == PackageManager.PERMISSION_DENIED) {
                            //ask permission
                            ActivityCompat.requestPermissions(outdoorTracks.this,
                                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                                    COARSE_LOCATION_PERMISSION_GRANTED);
                        }
                        if (permissionCheck2 == PackageManager.PERMISSION_GRANTED) {
                            PERMISSION_COARSE_LOCATION = true;

                        }
                        if (PERMISSION_COARSE_LOCATION || PERMISSION_FINE_LOCATION) {
                            intentDist();
                        }
// else {
//
//                            Toast.makeText(getApplicationContext(), "Location needed",
//                                    Toast.LENGTH_LONG).show();
//                        }
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

    public void intentDist() {
        Intent refreshScreen = new Intent(outdoorTracks.this, outdoorTracks_dist.class);
        startActivity(refreshScreen);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case FINE_LOCATION_PERMISSION_GRANTED: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    intentDist();
                    // intent a dist

                }

            }
            break;
            case COARSE_LOCATION_PERMISSION_GRANTED: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    intentDist();

                    // intent a dist

                }

            }
            break;


        }

    }

//    public class deleteScore implements View.OnClickListener {
//
//        int myLovelyVariable;
//
//        private deleteScore(int myLovelyVariable) {
//            this.myLovelyVariable = myLovelyVariable;
//        }
//
//        @Override
//        public void onClick(View v) {
//            AlertDialog.Builder builder = new AlertDialog.Builder(load_score_screen_dec.this);
//
//
//            builder.setMessage("GET CLOSEST TRACKS?");
//            builder.setPositiveButton("asd", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//
//                    Intent refreshScreen = new Intent(load_score_screen_dec.this, load_score_screen_dec.class);
//                    startActivity(refreshScreen);
//                }
//            });
//
//            builder.setNegativeButton(getString(R.string.del_deny), new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//
//                }
//            });
//
//            builder.show();
//
//
//        }
//
//
//    }
}
