package my.london.pablotrescoli.londonrunner.parkrun;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import my.london.pablotrescoli.londonrunner.R;
import com.squareup.picasso.Picasso;

public class WhatIsParkrun extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parkrun_what);

        setTitle("Parkrun");

        setAndDesignToolbar();

        populateLayout();

    }

    private void populateLayout() {
        TextView title = findViewById(R.id.title_parkrun);
        title.setText(R.string.parkrun_text1);

        ImageView imageV1 = findViewById(R.id.parkrun_image1);

        String x1 = getString(R.string.parkrun_image1_url) + ".png";
        Picasso.with(this)
                .load(x1)
                .resize(1000, 660)
                .into(imageV1);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.list_menu2, menu);
        return true;
    }


}
