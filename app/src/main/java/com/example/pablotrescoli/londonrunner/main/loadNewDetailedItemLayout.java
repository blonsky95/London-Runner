package com.example.pablotrescoli.londonrunner.main;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public class loadNewDetailedItemLayout implements View.OnClickListener{


        private int itemTypeID;
        private int itemTrackOrClubID;
        private Context sContext;

        loadNewDetailedItemLayout(int typeID, int trackOrClubID, Context context) {
            this.itemTypeID = typeID;
            this.itemTrackOrClubID = trackOrClubID;
            this.sContext=context;

        }

        @Override
        public void onClick(View v) {

            String siteIDStr = Integer.toString(itemTypeID) + Integer.toString(itemTrackOrClubID);
            Intent intent = new Intent(sContext, LondonRunnerDetailedItemDisplayer.class);
            intent.putExtra("siteID", siteIDStr);
            sContext.startActivity(intent);
        }


}
