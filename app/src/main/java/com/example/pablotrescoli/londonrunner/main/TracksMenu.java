package com.example.pablotrescoli.londonrunner.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.pablotrescoli.londonrunner.R;
import com.example.pablotrescoli.londonrunner.tracks.IndoorTracksDisplay;
import com.example.pablotrescoli.londonrunner.tracks.OutdoorTracksDisplay;

public class TracksMenu extends AppCompatActivity {

    final int OUTDOOR_TRACKS = 1;
    final int INDOOR_TRACKS = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submain);
        setTitle("Tracks");

        setAndDesignToolbar();

//        TextView subTitleTV = findViewById(R.id.subtitle_tv);
//        subTitleTV.setText(R.string.str1);

        TextView text1 = findViewById(R.id.text1);
        text1.setText(R.string.str2);
        text1.setOnClickListener(new goSection(OUTDOOR_TRACKS));

        TextView text2 = findViewById(R.id.text2);
        text2.setText(R.string.str3);
        text2.setOnClickListener(new goSection(INDOOR_TRACKS));

        TextView text3 = findViewById(R.id.text4);
        text3.setVisibility(View.GONE);

    }

    private class goSection implements View.OnClickListener {

        int sectionId;

        private goSection(int sectionId) {
            this.sectionId = sectionId;
        }

        @Override
        public void onClick(View v) {
            Intent intent;
            switch (sectionId) {
                case OUTDOOR_TRACKS:
                    intent = new Intent(TracksMenu.this, OutdoorTracksDisplay.class);
                    break;
                case INDOOR_TRACKS:
                    intent = new Intent(TracksMenu.this, IndoorTracksDisplay.class);
                    break;
                default:
                    intent = null;
            }
            if (intent == null) {
                return;
            }
            startActivity(intent);
        }
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

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
