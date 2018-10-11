package com.example.pablotrescoli.londonrunner.main;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pablotrescoli.londonrunner.R;
import com.squareup.picasso.Picasso;


public class LondonRunnerDetailedItemDisplayer extends AppCompatActivity {

    TextView itemHeadingPricesAndOpeningTimes, itemHeadingDescription, itemHeadingLocation, itemHeadingLinks,
            itemBodyPricesAndOpeningTimes, itemBodyDescription, itemBodyLocation, itemBodyLink1, itemBodyLink2;

    ImageView mainImage, mapsImage, clubImage;

    View separatorLine1, separatorLine2;

    int itemTypeID;
    int itemID;

    int OUTDOOR_TRACK_ID = 1;
    int INDOOR_TRACK_ID = 2;
    int CLUB_ID = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_site);

        setAndDesignToolbar();

        layoutInitialiser();

        Intent getId = getIntent();
        String siteIdStr = getId.getStringExtra("siteID");
        int[] type_ID = getTypeAndId(siteIdStr);
        itemTypeID = type_ID[0];
        itemID = type_ID[1];

        classifyLayoutType(itemTypeID, itemID);

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

    private void layoutInitialiser() {

        itemHeadingPricesAndOpeningTimes = findViewById(R.id.heading1);
        itemHeadingDescription = findViewById(R.id.heading2);
        itemHeadingLocation = findViewById(R.id.heading3);
        itemHeadingLinks = findViewById(R.id.heading4);
        itemBodyPricesAndOpeningTimes = findViewById(R.id.details);
        itemBodyDescription = findViewById(R.id.description);
        itemBodyLocation = findViewById(R.id.adress);
        itemBodyLink1 = findViewById(R.id.roster);
        itemBodyLink2 = findViewById(R.id.club_link);

        mainImage = findViewById(R.id.track_image);
        mapsImage = findViewById(R.id.maps_icon);
        clubImage = findViewById(R.id.club_icon);

        separatorLine1 = findViewById(R.id.lineview_1);
        separatorLine2 = findViewById(R.id.club_line);

    }

    private int[] getTypeAndId(String siteIdStr) {
        int[] X = new int[2];
        X[0] = Integer.parseInt(siteIdStr.substring(0, 1));
        X[1] = Integer.parseInt(siteIdStr.substring(1, siteIdStr.length())) + 1; //location ID (+1 because of position)

        return X;
    }

    private void classifyLayoutType(int itemTypeID, int itemID) {
        if (itemTypeID == CLUB_ID) {

            itemHeadingDescription.setText(R.string.club_desc);
            itemHeadingLinks.setText(R.string.links);

            itemBodyLink2.setText(getString(R.string.club_link));
            itemBodyLink2.setTypeface(null, Typeface.BOLD);
            itemBodyLink2.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                    getResources().getDimension(R.dimen.club_link_size));

            itemBodyLink1.setText(getString(R.string.club_roster));
            itemBodyLink1.setTypeface(null, Typeface.BOLD);
            itemBodyLink2.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                    getResources().getDimension(R.dimen.club_link_size));

            layoutTypeClubs(itemID);

        } else {
            layoutTypeTrack(itemTypeID, itemID);
        }
    }

    private void layoutTypeClubs(int itemID) {

        String[] club_array_name = getResources().getStringArray(R.array.club_name);
        String[] club_array_track = getResources().getStringArray(R.array.club_track);
        String[] club_array_description = getResources().getStringArray(R.array.club_desc);
        String[] club_array_mainPicURL = getResources().getStringArray(R.array.club_picture_URL);
        String[] club_array_clubRoster = getResources().getStringArray(R.array.club_link_clubRoster);
        String[] club_array_clubWebsite = getResources().getStringArray(R.array.club_link_clubWebsite);
        int[] club_intArray_trackID = getResources().getIntArray(R.array.club_trackID);

        String itemTitle = club_array_name[itemID - 1];
        String itemDescription = club_array_description[itemID - 1];
        String itemLocation = club_array_track[itemID - 1];
        String itemLink1 = club_array_clubRoster[itemID - 1];
        String itemLink2 = club_array_clubWebsite[itemID - 1];
        String itemMainPictureUrl = club_array_mainPicURL[itemID - 1];
        int itemTrackID = club_intArray_trackID[itemID - 1];

        clubItemLayout(itemTitle, itemDescription, itemLocation, itemLink1, itemLink2, itemMainPictureUrl, itemTrackID);

    }

    private void layoutTypeTrack(int itemTypeID, int itemID) {
        if (itemTypeID == INDOOR_TRACK_ID) {
            layoutTypeIndoorTrack(itemID);
        } else {
            layoutTypeOutdoorTrack(itemID);
        }

    }

    private void layoutTypeOutdoorTrack(int itemID) {
        String[] track_name = getResources().getStringArray(R.array.outdoor_track_name);
        String[] track_times = getResources().getStringArray(R.array.outdoor_track_times);
        String[] track_price1 = getResources().getStringArray(R.array.outdoor_track_price1);
        String[] track_desc = getResources().getStringArray(R.array.outdoor_track_desc);
        String[] track_adress = getResources().getStringArray(R.array.outdoor_track_adress);
        String[] track_picURL = getResources().getStringArray(R.array.outdoor_track_picURL);
        String[] track_mapsURL = getResources().getStringArray(R.array.outdoor_track_mapsURL);
        int[] track_clubID = getResources().getIntArray(R.array.outdoor_track_clubID);


        String itemTitle = track_name[itemID - 1];
        String itemTimes = track_times[itemID - 1];
        String itemPrice1 = track_price1[itemID - 1];
        String itemDesc = track_desc[itemID - 1];
        String itemAdress = track_adress[itemID - 1];
        String itemPicURL = track_picURL[itemID - 1];
        String itemMapURL = track_mapsURL[itemID - 1];
        int itemClubID = track_clubID[itemID - 1];

        outdoorTrackItemLayout(itemTitle, itemTimes, itemPrice1, itemDesc, itemAdress, itemPicURL, itemMapURL, itemClubID);

    }

    private void outdoorTrackItemLayout(String itemTitle, String itemTimes, String itemPrice1, String itemDesc, String itemAdress, String mainImageURL, String itemMapURL, int itemClubID) {
        setTitle(itemTitle);

        String bodyPricesAndOpeningTimes = itemPrice1 + "\n\n" + itemTimes;
        itemBodyPricesAndOpeningTimes.setText(bodyPricesAndOpeningTimes);

        itemBodyDescription.setText(itemDesc);

        itemBodyLocation.setText(itemAdress);
        itemBodyLocation.setTypeface(null, Typeface.BOLD);
        itemBodyLocation.setOnClickListener(new openMaps(itemMapURL));
        mapsImage.setOnClickListener(new openMaps(itemMapURL));


        if (itemClubID >= 0) {
            String[] club_array_name = getResources().getStringArray(R.array.club_name);
            String[] club_array_mainPicURL = getResources().getStringArray(R.array.club_picture_URL);
            String clubName = club_array_name[itemClubID];
            String clubPicURL = club_array_mainPicURL[itemClubID] + ".png";


            itemBodyLink1.setText(clubName);
            itemBodyLink1.setTypeface(null, Typeface.BOLD);
            itemBodyLink1.setOnClickListener(new loadNewDetailedItemLayout(CLUB_ID, itemClubID,this));

            itemBodyLink2.setVisibility(View.GONE);

            Picasso.with(this)
                    .load(clubPicURL)
                    .into(clubImage);
            clubImage.setOnClickListener(new loadNewDetailedItemLayout(CLUB_ID, itemClubID,this));
        } else {
            clubImage.setVisibility(View.GONE);
            itemHeadingLinks.setVisibility(View.GONE);
            itemBodyLink1.setVisibility(View.GONE);
            itemBodyLink2.setVisibility(View.GONE);
            separatorLine2.setVisibility(View.GONE);
        }
        String x = mainImageURL + ".png";
        Picasso.with(this)
                .load(x)
                .into(mainImage);
    }

    private void layoutTypeIndoorTrack(int itemID) {
        String[] track_name = getResources().getStringArray(R.array.indoor_track_name);
        String[] track_times = getResources().getStringArray(R.array.indoor_track_times);
        String[] track_price1 = getResources().getStringArray(R.array.indoor_track_price1);
        String[] track_desc = getResources().getStringArray(R.array.indoor_track_desc);
        String[] track_adress = getResources().getStringArray(R.array.indoor_track_address);
        String[] track_picURL = getResources().getStringArray(R.array.indoor_track_picURL);
        String[] track_mapsURL = getResources().getStringArray(R.array.indoor_track_mapsURL);


        String itemTitle = track_name[itemID - 1];
        String itemTimes = track_times[itemID - 1];
        String itemPrice1 = track_price1[itemID - 1];
        String itemDesc = track_desc[itemID - 1];
        String itemAdress = track_adress[itemID - 1];
        String itemPicURL = track_picURL[itemID - 1];
        String itemMapURL = track_mapsURL[itemID - 1];

        indoorTrackItemLayout(itemTitle, itemTimes, itemPrice1, itemDesc, itemAdress, itemPicURL, itemMapURL);

    }

    private void indoorTrackItemLayout(String itemTitle, String itemTimes, String itemPrice1, String itemDesc, String itemAdress, String mainImageURL, String itemMapURL) {
        setTitle(itemTitle);

        String bodyPricesAndOpeningTimes = itemPrice1 + "\n\n" + itemTimes;
        itemBodyPricesAndOpeningTimes.setText(bodyPricesAndOpeningTimes);

        itemBodyDescription.setText(itemDesc);

        itemBodyLocation.setText(itemAdress);
        itemBodyLocation.setTypeface(null, Typeface.BOLD);
        itemBodyLocation.setOnClickListener(new openMaps(itemMapURL));

        clubImage.setVisibility(View.GONE);
        itemHeadingLinks.setVisibility(View.GONE);
        itemBodyLink1.setVisibility(View.GONE);
        itemBodyLink2.setVisibility(View.GONE);
        separatorLine2.setVisibility(View.GONE);

        String x = mainImageURL + ".png";
        Picasso.with(this)
                .load(x)
                .into(mainImage);
        mapsImage.setOnClickListener(new openMaps(itemMapURL));

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

    private void clubItemLayout(String itemTitle, String itemDescription, String itemLocation, String itemLink1, String itemLink2, String mainImageURL, int itemTrackOfClubID) {

        setTitle(itemTitle);

        itemHeadingPricesAndOpeningTimes.setVisibility(View.GONE);
        itemBodyPricesAndOpeningTimes.setVisibility(View.GONE);
        separatorLine1.setVisibility(View.GONE);

        itemBodyDescription.setText(itemDescription);

        itemBodyLocation.setText(itemLocation);
        itemBodyLocation.setTypeface(null, Typeface.BOLD);
        itemBodyLocation.setOnClickListener(new loadNewDetailedItemLayout(OUTDOOR_TRACK_ID, itemTrackOfClubID,this));
        mapsImage.setVisibility(View.GONE);

        itemBodyLink1.setOnClickListener(new goWebsite(itemLink1));
        itemBodyLink2.setOnClickListener(new goWebsite(itemLink2));
        clubImage.setVisibility(View.GONE);

        String x = mainImageURL + ".png";
        Picasso.with(this)
                .load(x)
                .into(mainImage);

    }

    private class goWebsite implements View.OnClickListener {
        String itemURL;

        goWebsite(String itemLink1) {
            this.itemURL = itemLink1;
        }

        @Override
        public void onClick(View v) {
            Intent web1 = new Intent(Intent.ACTION_VIEW);
            web1.setData(Uri.parse(itemURL));
            startActivity(web1);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.list_menu2, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}