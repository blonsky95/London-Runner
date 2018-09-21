package com.example.pablotrescoli.londonrunner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textview1=findViewById(R.id.text1);
        textview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goScreen1=new Intent(MainActivity.this,outdoorTracks.class);
                startActivity(goScreen1);

            }
        });

        TextView textview2=findViewById(R.id.text2);
        textview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goScreen2=new Intent(MainActivity.this,indoorTracks.class);
                startActivity(goScreen2);

            }
        });

        TextView textview4=findViewById(R.id.text4);
        textview4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goScreen4=new Intent(MainActivity.this,runningRoutes.class);
                startActivity(goScreen4);

            }
        });
    }
}
