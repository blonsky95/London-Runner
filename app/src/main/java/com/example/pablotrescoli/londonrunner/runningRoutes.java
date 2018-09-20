package com.example.pablotrescoli.londonrunner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ListView;

import java.util.ArrayList;

public class runningRoutes extends AppCompatActivity{
    int SITE_ID=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outdoortracks);
        setTitle("London routes");

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        final ArrayList<runningItem> items=new ArrayList<runningItem>();
        items.add(new runningItem(R.string.type3_1_name,R.string.type3_1_address,R.string.type3_1_distance,R.string.type3_1_picURL));
        items.add(new runningItem(R.string.type3_2_name,R.string.type3_2_address,R.string.type3_2_distance,R.string.type3_2_picURL));
        items.add(new runningItem(R.string.type3_3_name,R.string.type3_3_address,R.string.type3_3_distance,R.string.type3_3_picURL));
        items.add(new runningItem(R.string.type3_4_name,R.string.type3_4_address,R.string.type3_4_distance,R.string.type3_4_picURL));
        items.add(new runningItem(R.string.type3_5_name,R.string.type3_5_address,R.string.type3_5_distance,R.string.type3_5_picURL));
        items.add(new runningItem(R.string.type3_6_name,R.string.type3_6_address,R.string.type3_6_distance,R.string.type3_6_picURL));
        items.add(new runningItem(R.string.type3_7_name,R.string.type3_7_address,R.string.type3_7_distance,R.string.type3_7_picURL));
        items.add(new runningItem(R.string.type3_8_name,R.string.type3_8_address,R.string.type3_8_distance,R.string.type3_8_picURL));

        int[] fiveClosestIds = {-1};

        runningItemAdapter adapter=new runningItemAdapter(this,items,R.color.transp_bg,SITE_ID,fiveClosestIds);
        ListView listView = (ListView)findViewById(R.id.list);
//
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.list_menu2, menu);
        return true;
    }
}
