package com.example.pablotrescoli.londonrunner;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class indoorTracks extends AppCompatActivity{
    int SITE_ID=2;

    final int FINE_LOCATION_PERMISSION_GRANTED = 111;
    final int COARSE_LOCATION_PERMISSION_GRANTED = 112;

    boolean PERMISSION_FINE_LOCATION = false;
    boolean PERMISSION_COARSE_LOCATION = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outdoortracks);
        setTitle("Closest indoor tracks");

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        final ArrayList<runningItem> items=new ArrayList<runningItem>();
        items.add(new runningItem(R.string.type2_9_name,R.string.type2_9_address,R.string.type2_9_price2,R.string.type2_9_picURL));
        items.add(new runningItem(R.string.type2_18_name,R.string.type2_18_address,R.string.type2_18_price2,R.string.type2_18_picURL));
        items.add(new runningItem(R.string.type2_20_name,R.string.type2_20_address,R.string.type2_20_price2,R.string.type2_20_picURL));
        items.add(new runningItem(R.string.type2_25_name,R.string.type2_25_address,R.string.type2_25_price2,R.string.type2_25_picURL));
        items.add(new runningItem(R.string.type2_26_name,R.string.type2_26_address,R.string.type2_26_price2,R.string.type2_26_picURL));
        items.add(new runningItem(R.string.type2_32_name,R.string.type2_32_address,R.string.type2_32_price2,R.string.type2_32_picURL));

        int[] fiveClosestIds = {-1};

        runningItemAdapter adapter=new runningItemAdapter(this,items,R.color.transp_bg,SITE_ID,fiveClosestIds);
        ListView listView = (ListView)findViewById(R.id.list);
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

                        int permissionCheck1 = ContextCompat.checkSelfPermission(indoorTracks.this,
                                Manifest.permission.ACCESS_FINE_LOCATION);
                        if (permissionCheck1 == PackageManager.PERMISSION_DENIED) {
                            //ask permission
                            ActivityCompat.requestPermissions(indoorTracks.this,
                                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                    FINE_LOCATION_PERMISSION_GRANTED);
                        }
                        if (permissionCheck1 == PackageManager.PERMISSION_GRANTED) {
                            PERMISSION_FINE_LOCATION = true;

                        }
                        int permissionCheck2 = ContextCompat.checkSelfPermission(indoorTracks.this,
                                Manifest.permission.ACCESS_COARSE_LOCATION);
                        if (permissionCheck2 == PackageManager.PERMISSION_DENIED) {
                            //ask permission
                            ActivityCompat.requestPermissions(indoorTracks.this,
                                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                                    COARSE_LOCATION_PERMISSION_GRANTED);
                        }
                        if (permissionCheck2 == PackageManager.PERMISSION_GRANTED) {
                            PERMISSION_COARSE_LOCATION = true;

                        }
                        if (PERMISSION_COARSE_LOCATION || PERMISSION_FINE_LOCATION) {
                            intentDist();
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

    public void intentDist() {
        Intent refreshScreen = new Intent(indoorTracks.this, indoorTracks_dist.class);
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
                }
            }
            break;

        }
    }
}
