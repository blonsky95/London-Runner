package com.example.pablotrescoli.londonrunner;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bogdwellers.pinchtozoom.ImageMatrixTouchHandler;
import com.squareup.picasso.Picasso;


public class detailedSite extends AppCompatActivity {


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_site);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        TextView block1TV = findViewById(R.id.name);
        TextView block1details = findViewById(R.id.details);
        TextView block1adressTV = findViewById(R.id.adress);
        ImageView imageV = findViewById(R.id.track_image);
        imageV.setOnTouchListener(new ImageMatrixTouchHandler(this));
        TextView block2TV = findViewById(R.id.description);

        Intent getId = getIntent();
        String siteIdStr = getId.getStringExtra("siteID");
        int[] type_ID = getTypeAndId(siteIdStr);
        String x = "";
        String block1 = "";
        String block1adress = "";
        String urlString = "";
        switch (type_ID[0]) {
            case 1:
                switch (type_ID[1]) {
                    case 1:
                        setTitle(getString(R.string.type1_1_name));

                        block1 = getString(R.string.type1_1_price1) + "\n\n" + getString(R.string.type1_1_times);
                        block1TV.setText(getString(R.string.type1_1_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type1_1_address) + " - open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString = getString(R.string.type1_1_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type1_1_desc);
                        x = this.getResources().getString(R.string.type1_1_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 2:
                        setTitle(getString(R.string.type1_2_name));

                        block1 = getString(R.string.type1_2_price1) + "\n\n" + getString(R.string.type1_2_times);
                        block1TV.setText(getString(R.string.type1_2_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type1_2_address) + " - open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString = getString(R.string.type1_2_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type1_2_desc);
                        x = this.getResources().getString(R.string.type1_2_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 3:
                        setTitle(getString(R.string.type1_3_name));

                        block1 = getString(R.string.type1_1_price1) + "\n\n" + getString(R.string.type1_1_times);
                        block1TV.setText(getString(R.string.type1_3_name));
                        block1details.setText(block1);

                        block1adress = getString(R.string.type1_1_address) + " open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString = getString(R.string.type1_3_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type1_1_desc);
                        x = this.getResources().getString(R.string.type1_3_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 4:
                        setTitle(getString(R.string.type1_4_name));

                        block1 = getString(R.string.type1_4_price1) + "\n\n" + getString(R.string.type1_4_times);
                        block1TV.setText(getString(R.string.type1_4_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type1_4_address) + " open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString = getString(R.string.type1_4_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type1_4_desc);
                        x = this.getResources().getString(R.string.type1_4_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 5:
                        setTitle(getString(R.string.type1_5_name));

                        block1 = getString(R.string.type1_5_price1) + "\n\n" + getString(R.string.type1_5_times);
                        block1TV.setText(getString(R.string.type1_5_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type1_5_address) + " open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString = getString(R.string.type1_5_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type1_5_desc);
                        x = this.getResources().getString(R.string.type1_5_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 6:
                        setTitle(getString(R.string.type1_6_name));

                        block1 = getString(R.string.type1_6_price1) + "\n\n" + getString(R.string.type1_6_times);
                        block1TV.setText(getString(R.string.type1_6_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type1_6_address) + " open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString = getString(R.string.type1_6_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type1_6_desc);
                        x = this.getResources().getString(R.string.type1_6_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 7:
                        setTitle(getString(R.string.type1_7_name));

                        block1 = getString(R.string.type1_7_price1) + "\n\n" + getString(R.string.type1_7_times);
                        block1TV.setText(getString(R.string.type1_7_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type1_7_address) + " open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString = getString(R.string.type1_7_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type1_7_desc);
                        x = this.getResources().getString(R.string.type1_7_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 8:
                        setTitle(getString(R.string.type1_8_name));

                        block1 = getString(R.string.type1_8_price1) + "\n\n" + getString(R.string.type1_8_times);
                        block1TV.setText(getString(R.string.type1_8_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type1_8_address) + " open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString = getString(R.string.type1_8_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type1_8_desc);
                        x = this.getResources().getString(R.string.type1_8_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 9:
                        setTitle(getString(R.string.type1_9_name));

                        block1 = getString(R.string.type1_9_price1) + "\n\n" + getString(R.string.type1_9_times);
                        block1TV.setText(getString(R.string.type1_9_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type1_9_address) + " open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString = getString(R.string.type1_9_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type1_9_desc);
                        x = this.getResources().getString(R.string.type1_9_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 10:
                        setTitle(getString(R.string.type1_10_name));

                        block1 = getString(R.string.type1_10_price1) + "\n\n" + getString(R.string.type1_10_times);
                        block1TV.setText(getString(R.string.type1_10_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type1_10_address) + " open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString = getString(R.string.type1_10_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type1_10_desc);
                        x = this.getResources().getString(R.string.type1_10_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 11:
                        setTitle(getString(R.string.type1_11_name));

                        block1 = getString(R.string.type1_11_price1) + "\n\n" + getString(R.string.type1_11_times);
                        block1TV.setText(getString(R.string.type1_11_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type1_11_address) + " open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString = getString(R.string.type1_11_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type1_11_desc);
                        x = this.getResources().getString(R.string.type1_11_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 12:
                        setTitle(getString(R.string.type1_12_name));

                        block1 = getString(R.string.type1_12_price1) + "\n\n" + getString(R.string.type1_12_times);
                        block1TV.setText(getString(R.string.type1_12_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type1_12_address) + " open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString = getString(R.string.type1_12_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type1_12_desc);
                        x = this.getResources().getString(R.string.type1_12_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 13:
                        setTitle(getString(R.string.type1_13_name));

                        block1 = getString(R.string.type1_13_price1) + "\n\n" + getString(R.string.type1_13_times);
                        block1TV.setText(getString(R.string.type1_13_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type1_13_address) + " open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString = getString(R.string.type1_13_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type1_13_desc);
                        x = this.getResources().getString(R.string.type1_13_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 14:
                        setTitle(getString(R.string.type1_14_name));

                        block1 = getString(R.string.type1_14_price1) + "\n\n" + getString(R.string.type1_14_times);
                        block1TV.setText(getString(R.string.type1_14_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type1_14_address) + " open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString = getString(R.string.type1_14_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type1_14_desc);
                        x = this.getResources().getString(R.string.type1_14_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 15:
                        setTitle(getString(R.string.type1_15_name));

                        block1 = getString(R.string.type1_15_price1) + "\n\n" + getString(R.string.type1_15_times);
                        block1TV.setText(getString(R.string.type1_15_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type1_15_address) + " open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString = getString(R.string.type1_15_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type1_15_desc);
                        x = this.getResources().getString(R.string.type1_15_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 16:
                        setTitle(getString(R.string.type1_16_name));

                        block1 = getString(R.string.type1_16_price1) + "\n\n" + getString(R.string.type1_16_times);
                        block1TV.setText(getString(R.string.type1_16_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type1_16_address) + " open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString = getString(R.string.type1_16_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type1_16_desc);
                        x = this.getResources().getString(R.string.type1_16_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 17:
                        setTitle(getString(R.string.type1_17_name));

                        block1 = getString(R.string.type1_17_price1) + "\n\n" + getString(R.string.type1_17_times);
                        block1TV.setText(getString(R.string.type1_17_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type1_17_address) + " open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString = getString(R.string.type1_17_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type1_17_desc);
                        x = this.getResources().getString(R.string.type1_17_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 18:
                        setTitle(getString(R.string.type1_18_name));

                        block1 = getString(R.string.type1_18_price1) + "\n\n" + getString(R.string.type1_18_times);
                        block1TV.setText(getString(R.string.type1_18_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type1_18_address) + " open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString = getString(R.string.type1_18_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type1_18_desc);
                        x = this.getResources().getString(R.string.type1_18_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 19:
                        setTitle(getString(R.string.type1_19_name));

                        block1 = getString(R.string.type1_19_price1) + "\n\n" + getString(R.string.type1_19_times);
                        block1TV.setText(getString(R.string.type1_19_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type1_19_address) + " open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString = getString(R.string.type1_19_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type1_19_desc);
                        x = this.getResources().getString(R.string.type1_19_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 20:
                        setTitle(getString(R.string.type1_20_name));

                        block1 = getString(R.string.type1_20_price1) + "\n\n" + getString(R.string.type1_20_times);
                        block1TV.setText(getString(R.string.type1_20_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type1_20_address) + " open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString = getString(R.string.type1_20_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type1_20_desc);
                        x = this.getResources().getString(R.string.type1_20_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 21:
                        setTitle(getString(R.string.type1_21_name));

                        block1 = getString(R.string.type1_21_price1) + "\n\n" + getString(R.string.type1_21_times);
                        block1TV.setText(getString(R.string.type1_21_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type1_21_address) + " open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString = getString(R.string.type1_21_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type1_21_desc);
                        x = this.getResources().getString(R.string.type1_21_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 22:
                        setTitle(getString(R.string.type1_22_name));

                        block1 = getString(R.string.type1_22_price1) + "\n\n" + getString(R.string.type1_22_times);
                        block1TV.setText(getString(R.string.type1_22_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type1_22_address) + " open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString = getString(R.string.type1_22_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type1_22_desc);
                        x = this.getResources().getString(R.string.type1_22_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 23:
                        setTitle(getString(R.string.type1_23_name));

                        block1 = getString(R.string.type1_23_price1) + "\n\n" + getString(R.string.type1_23_times);
                        block1TV.setText(getString(R.string.type1_23_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type1_23_address) + " open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString = getString(R.string.type1_23_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type1_23_desc);
                        x = this.getResources().getString(R.string.type1_23_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 24:
                        setTitle(getString(R.string.type1_24_name));

                        block1 = getString(R.string.type1_24_price1) + "\n\n" + getString(R.string.type1_24_times);
                        block1TV.setText(getString(R.string.type1_24_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type1_24_address) + " open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString = getString(R.string.type1_24_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type1_24_desc);
                        x = this.getResources().getString(R.string.type1_24_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 25:
                        setTitle(getString(R.string.type1_25_name));

                        block1 = getString(R.string.type1_25_price1) + "\n\n" + getString(R.string.type1_25_times);
                        block1TV.setText(getString(R.string.type1_25_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type1_25_address) + " open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString = getString(R.string.type1_25_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type1_25_desc);
                        x = this.getResources().getString(R.string.type1_25_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 26:
                        setTitle(getString(R.string.type1_26_name));

                        block1 = getString(R.string.type1_26_price1) + "\n\n" + getString(R.string.type1_26_times);
                        block1TV.setText(getString(R.string.type1_26_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type1_26_address) + " open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString = getString(R.string.type1_26_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type1_26_desc);
                        x = this.getResources().getString(R.string.type1_26_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 27:
                        setTitle(getString(R.string.type1_27_name));

                        block1 = getString(R.string.type1_27_price1) + "\n\n" + getString(R.string.type1_27_times);
                        block1TV.setText(getString(R.string.type1_27_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type1_27_address) + " open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString = getString(R.string.type1_27_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type1_27_desc);
                        x = this.getResources().getString(R.string.type1_27_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 28:
                        setTitle(getString(R.string.type1_28_name));

                        block1 = getString(R.string.type1_28_price1) + "\n\n" + getString(R.string.type1_28_times);
                        block1TV.setText(getString(R.string.type1_28_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type1_28_address) + " open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString = getString(R.string.type1_28_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type1_28_desc);
                        x = this.getResources().getString(R.string.type1_28_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 29:
                        setTitle(getString(R.string.type1_29_name));

                        block1 = getString(R.string.type1_29_price1) + "\n\n" + getString(R.string.type1_29_times);
                        block1TV.setText(getString(R.string.type1_29_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type1_29_address) + " open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString = getString(R.string.type1_29_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type1_29_desc);
                        x = this.getResources().getString(R.string.type1_29_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 30:
                        setTitle(getString(R.string.type1_30_name));

                        block1 = getString(R.string.type1_30_price1) + "\n\n" + getString(R.string.type1_30_times);
                        block1TV.setText(getString(R.string.type1_30_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type1_30_address) + " open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString = getString(R.string.type1_30_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type1_30_desc);
                        x = this.getResources().getString(R.string.type1_30_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 31:
                        setTitle(getString(R.string.type1_31_name));

                        block1 = getString(R.string.type1_31_price1) + "\n\n" + getString(R.string.type1_31_times);
                        block1TV.setText(getString(R.string.type1_31_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type1_31_address) + " open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString = getString(R.string.type1_31_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type1_31_desc);
                        x = this.getResources().getString(R.string.type1_31_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 32:
                        setTitle(getString(R.string.type1_32_name));

                        block1 = getString(R.string.type1_32_price1) + "\n\n" + getString(R.string.type1_32_times);
                        block1TV.setText(getString(R.string.type1_32_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type1_32_address) + " open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString = getString(R.string.type1_32_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type1_32_desc);
                        x = this.getResources().getString(R.string.type1_32_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 33:
                        setTitle(getString(R.string.type1_33_name));

                        block1 = getString(R.string.type1_33_price1) + "\n\n" + getString(R.string.type1_33_times);
                        block1TV.setText(getString(R.string.type1_33_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type1_33_address) + " open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString = getString(R.string.type1_33_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type1_33_desc);
                        x = this.getResources().getString(R.string.type1_33_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                }
                break;

            case 2:
                switch (type_ID[1]) {
                    case 1:
                        setTitle(getString(R.string.type2_9_name));

                        block1 = getString(R.string.type2_9_price1) + "\n\n" + getString(R.string.type2_9_times);
                        block1TV.setText(getString(R.string.type2_9_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type2_9_address) + " - open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString=getString(R.string.type1_9_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type2_9_desc);
                        x = this.getResources().getString(R.string.type2_9_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 2:
                        setTitle(getString(R.string.type2_18_name));

                        block1 = getString(R.string.type2_18_price1) + "\n\n" + getString(R.string.type2_18_times);
                        block1TV.setText(getString(R.string.type2_18_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type2_18_address) + " - open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString=getString(R.string.type1_18_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type2_18_desc);

                        x = this.getResources().getString(R.string.type2_18_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 3:
                        setTitle(getString(R.string.type2_20_name));

                        block1 = getString(R.string.type2_20_price1) + "\n\n" + getString(R.string.type2_20_times);
                        block1TV.setText(getString(R.string.type2_20_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type2_20_address) + " - open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString=getString(R.string.type1_20_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type2_20_desc);


                        x = this.getResources().getString(R.string.type2_20_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 4:
                        setTitle(getString(R.string.type2_25_name));

                        block1 = getString(R.string.type2_25_price1) + "\n\n" + getString(R.string.type2_25_times);
                        block1TV.setText(getString(R.string.type2_25_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type2_25_address) + " - open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString=getString(R.string.type1_25_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type2_25_desc);

                        x = this.getResources().getString(R.string.type2_25_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 5:
                        setTitle(getString(R.string.type2_26_name));

                        block1 = getString(R.string.type2_26_price1) + "\n\n" + getString(R.string.type2_26_times);
                        block1TV.setText(getString(R.string.type2_26_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type2_26_address) + " - open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString=getString(R.string.type1_26_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type2_26_desc);

                        x = this.getResources().getString(R.string.type2_26_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 6:
                        setTitle(getString(R.string.type2_32_name));

                        block1 = getString(R.string.type2_32_price1) + "\n\n" + getString(R.string.type2_32_times);
                        block1TV.setText(getString(R.string.type2_32_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type2_32_address) + " - open in Google Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString=getString(R.string.type1_32_mapsURL);
                        block1adressTV.setOnClickListener(new openMaps(urlString));
                        block2TV.setText(R.string.type2_32_desc);


                        x = this.getResources().getString(R.string.type2_32_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                }
                break;
            case 3:
                switch (type_ID[1]) {
                    case 1:
                        setTitle(getString(R.string.type3_1_name));

                        block1 = "Distance: " + getString(R.string.type3_1_distance) + "\n\nElevation: " +
                                getString(R.string.type3_1_elevation) + "\n\nSurface: " + getString(R.string.type3_1_surface) + "\n";

                        block1TV.setText(getString(R.string.type3_1_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type3_1_address) + " - open Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString=getString(R.string.type3_1_mapURL);
                        block1adressTV.setOnClickListener(new openRoute(urlString));
                        block2TV.setText(R.string.type3_1_desc);

                        x = this.getResources().getString(R.string.type3_1_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 2:
                        setTitle(getString(R.string.type3_2_name));

                        block1 = "Distance: " + getString(R.string.type3_2_distance) + "\n\nElevation: " +
                                getString(R.string.type3_2_elevation) + "\n\nSurface: " + getString(R.string.type3_2_surface) + "\n";

                        block1TV.setText(getString(R.string.type3_2_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type3_2_address) + " - open Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString=getString(R.string.type3_2_mapURL);
                        block1adressTV.setOnClickListener(new openRoute(urlString));
                        block2TV.setText(R.string.type3_2_desc);

                        x = this.getResources().getString(R.string.type3_2_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 3:
                        setTitle(getString(R.string.type3_3_name));

                        block1 = "Distance: " + getString(R.string.type3_3_distance) + "\n\nElevation: " +
                                getString(R.string.type3_3_elevation) + "\n\nSurface: " + getString(R.string.type3_3_surface) + "\n";

                        block1TV.setText(getString(R.string.type3_3_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type3_3_address) + " - open Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString=getString(R.string.type3_3_mapURL);
                        block1adressTV.setOnClickListener(new openRoute(urlString));
                        block2TV.setText(R.string.type3_3_desc);

                        x = this.getResources().getString(R.string.type3_3_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 4:
                        setTitle(getString(R.string.type3_4_name));

                        block1 = "Distance: " + getString(R.string.type3_4_distance) + "\n\nElevation: " +
                                getString(R.string.type3_4_elevation) + "\n\nSurface: " + getString(R.string.type3_4_surface) + "\n";

                        block1TV.setText(getString(R.string.type3_4_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type3_4_address) + " - open Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString=getString(R.string.type3_4_mapURL);
                        block1adressTV.setOnClickListener(new openRoute(urlString));
                        block2TV.setText(R.string.type3_4_desc);

                        x = this.getResources().getString(R.string.type3_4_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 5:
                        setTitle(getString(R.string.type3_5_name));

                        block1 = "Distance: " + getString(R.string.type3_5_distance) + "\n\nElevation: " +
                                getString(R.string.type3_5_elevation) + "\n\nSurface: " + getString(R.string.type3_5_surface) + "\n";

                        block1TV.setText(getString(R.string.type3_5_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type3_5_address) + " - open Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString=getString(R.string.type3_5_mapURL);
                        block1adressTV.setOnClickListener(new openRoute(urlString));
                        block2TV.setText(R.string.type3_5_desc);

                        x = this.getResources().getString(R.string.type3_5_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 6:
                        setTitle(getString(R.string.type3_6_name));

                        block1 = "Distance: " + getString(R.string.type3_6_distance) + "\n\nElevation: " +
                                getString(R.string.type3_6_elevation) + "\n\nSurface: " + getString(R.string.type3_6_surface) + "\n";

                        block1TV.setText(getString(R.string.type3_6_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type3_6_address) + " - open Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString=getString(R.string.type3_6_mapURL);
                        block1adressTV.setOnClickListener(new openRoute(urlString));
                        block2TV.setText(R.string.type3_6_desc);

                        x = this.getResources().getString(R.string.type3_6_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 7:
                        setTitle(getString(R.string.type3_7_name));

                        block1 = "Distance: " + getString(R.string.type3_7_distance) + "\n\nElevation: " +
                                getString(R.string.type3_7_elevation) + "\n\nSurface: " + getString(R.string.type3_7_surface) + "\n";

                        block1TV.setText(getString(R.string.type3_7_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type3_7_address) + " - open Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString=getString(R.string.type3_7_mapURL);
                        block1adressTV.setOnClickListener(new openRoute(urlString));
                        block2TV.setText(R.string.type3_7_desc);

                        x = this.getResources().getString(R.string.type3_7_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;
                    case 8:
                        setTitle(getString(R.string.type3_8_name));

                        block1 = "Distance: " + getString(R.string.type3_8_distance) + "\n\nElevation: " +
                                getString(R.string.type3_8_elevation) + "\n\nSurface: " + getString(R.string.type3_8_surface) + "\n";

                        block1TV.setText(getString(R.string.type3_8_name));
                        block1details.setText(block1);
                        block1adress = getString(R.string.type3_8_address) + " - open Maps";
                        block1adressTV.setText(block1adress);
                        block1adressTV.setTypeface(null, Typeface.BOLD);
                        urlString=getString(R.string.type3_8_mapURL);
                        block1adressTV.setOnClickListener(new openRoute(urlString));
                        block2TV.setText(R.string.type3_8_desc);

                        x = this.getResources().getString(R.string.type3_8_picURL) + ".png";
                        Picasso.with(this)
                                .load(x)
                                .into(imageV);

                        break;

                }
                break;

        }


    }

    private int[] getTypeAndId(String siteIdStr) {
        int[] X = new int[2];
        char char1 = siteIdStr.charAt(0);
        X[0] = Integer.parseInt(siteIdStr.substring(0, 1));
        X[1] = Integer.parseInt(siteIdStr.substring(1, siteIdStr.length())) + 1; //location ID (+1 because of position)

        return X;
    }

    public class openMaps implements View.OnClickListener {

        String mapsUrl;

        openMaps(String mapsUrl) {
            this.mapsUrl = mapsUrl;

        }

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(mapsUrl));
            intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
            startActivity(intent);
        }

    }
    public class openRoute implements View.OnClickListener {

        String routeURL;

        openRoute(String routeURL) {
            this.routeURL = routeURL;

        }

        @Override
        public void onClick(View v) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(routeURL));
            startActivity(browserIntent);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.list_menu2, menu);
        return true;
    }
}