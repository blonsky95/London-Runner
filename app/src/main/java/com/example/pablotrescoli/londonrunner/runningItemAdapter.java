package com.example.pablotrescoli.londonrunner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class runningItemAdapter extends ArrayAdapter<runningItem> {

    private int sColorId;
    private Context sContext;
    private int sSiteID;
    int[] sCloseIds;

    public runningItemAdapter(Activity context, ArrayList<runningItem> items, int colorId, int siteID, int[] closeIds) {
        super(context, 0, items);
        sContext = context;
        sColorId = colorId;
        sSiteID = siteID;
        sCloseIds = closeIds;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_format, parent, false);
        }
        runningItem currentItem = getItem(position);

        TextView nameTV = (TextView) listItemView.findViewById(R.id.item_name);
        nameTV.setText(currentItem.getName());


        TextView locationTV = (TextView) listItemView.findViewById(R.id.item_location);
        locationTV.setText(currentItem.getLocation());

        if (!currentItem.isRunningRoute()) {

            if (currentItem.hasDistance()) {

                TextView priceTV = (TextView) listItemView.findViewById(R.id.item_price);
                priceTV.setText(currentItem.getDistance());
            } else {

                TextView priceTV = (TextView) listItemView.findViewById(R.id.item_price);
                priceTV.setText(currentItem.getPrice());
            }
        }

        ImageView imageV = (ImageView) listItemView.findViewById(R.id.image);
        String x = sContext.getResources().getString(currentItem.getImageId()) + ".png";
        Picasso.with(getContext())
                .load(x)
                .into(imageV);

        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), sColorId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        if (position < sCloseIds.length) {
            if (sCloseIds[position] >= 0) {
                position = sCloseIds[position];
            }
        }
        textContainer.setOnClickListener(new MyLovelyOnClickListener(sSiteID, position));

        return listItemView;
    }

    public class MyLovelyOnClickListener implements View.OnClickListener {

        int myLovelyVariable1;
        int myLovelyVariable2;

        public MyLovelyOnClickListener(int myLovelyVariable1, int myLovelyVariable2) {
            this.myLovelyVariable1 = myLovelyVariable1;
            this.myLovelyVariable2 = myLovelyVariable2;

        }

        @Override
        public void onClick(View v) {

            String siteIDStr = Integer.toString(myLovelyVariable1) + Integer.toString(myLovelyVariable2);
            Intent intent = new Intent(getContext(), detailedSite.class);
            intent.putExtra("siteID", siteIDStr);
            getContext().startActivity(intent);
        }

    }

    ;


}
