package com.example.pablotrescoli.londonrunner.parkrun;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pablotrescoli.londonrunner.R;

public class ResultsRequest extends AppCompatActivity {
    EditText id_ET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parkrun_preres);

        setTitle("Athlete ID");

        setAndDesignToolbar();

        id_ET = findViewById(R.id.id_ET);

        Button btn1 = findViewById(R.id.results_btn);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String athleteID = id_ET.getText().toString().trim();
                String resultsURL = createURL(athleteID);
                Intent intent = new Intent(ResultsRequest.this, ResultsDisplay.class);
                intent.putExtra("resultsURL", resultsURL);
                startActivity(intent);
            }
        });

    }

    private String createURL(String athleteID) {
        String URL;
        if (athleteID.contains("A")) {
            athleteID = athleteID.substring(1, athleteID.length());
        }
        String part1URL = "http://www.parkrun.org.uk/results/athleteresultshistory/?athleteNumber=";
        URL = part1URL + athleteID;

        return URL;

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
