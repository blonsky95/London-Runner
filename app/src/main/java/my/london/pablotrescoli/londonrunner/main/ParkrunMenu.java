package my.london.pablotrescoli.londonrunner.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import my.london.pablotrescoli.londonrunner.R;

import my.london.pablotrescoli.londonrunner.parkrun.RegisterNewUser;
import my.london.pablotrescoli.londonrunner.parkrun.ResultsRequest;
import my.london.pablotrescoli.londonrunner.parkrun.WhatIsParkrun;

public class ParkrunMenu extends AppCompatActivity{

    final int WHAT_IS_PARKRUN_ID = 1;
    final int REGISTER_ID = 2;
    final int RESULTS_ID = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submain);
        setTitle("Parkrun");

        setAndDesignToolbar();

//        TextView subTitleTV=findViewById(R.id.subtitle_tv);
//        subTitleTV.setText(R.string.str1);

        TextView whatIsParkrunTextView = findViewById(R.id.text1);
        whatIsParkrunTextView.setText(R.string.parkrun_text1);
        whatIsParkrunTextView.setOnClickListener(new goSection(WHAT_IS_PARKRUN_ID));

        TextView resultsTextView = findViewById(R.id.text2);
        resultsTextView.setText(R.string.parkrun_text2);
        resultsTextView.setOnClickListener(new goSection(RESULTS_ID));

        TextView registerTextView = findViewById(R.id.text4);
        registerTextView.setText(R.string.parkrun_text3);
        registerTextView.setOnClickListener(new goSection(REGISTER_ID));

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
                case WHAT_IS_PARKRUN_ID:
                    intent = new Intent(ParkrunMenu.this, WhatIsParkrun.class);
                    break;
                case RESULTS_ID:
                    intent = new Intent(ParkrunMenu.this, ResultsRequest.class);
                    break;
                case REGISTER_ID:
                    intent = new Intent(ParkrunMenu.this, RegisterNewUser.class);
                    break;
                default:
                    intent = null;
            }
            if (intent==null){
                return;
            }
            startActivity(intent);
        }
    }

    private void setAndDesignToolbar() {

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        if (getSupportActionBar()!=null){
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
