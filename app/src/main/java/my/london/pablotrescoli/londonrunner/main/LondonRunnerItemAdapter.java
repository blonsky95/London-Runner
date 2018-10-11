package my.london.pablotrescoli.londonrunner.main;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import my.london.pablotrescoli.londonrunner.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LondonRunnerItemAdapter extends ArrayAdapter<LondonRunnerItem> {

    private int sSectionID;
    private int[] sCloserItemsIDs;

    private final int CLUBS_ID = 3;

    private TextView variableTV;
    private ImageView imageV;
    private View textContainer;

    private LondonRunnerItem currentLondonRunnerItem;

    public LondonRunnerItemAdapter(Activity context, ArrayList<LondonRunnerItem> items, int sectionID, int[] closerItemsIDs) {
        super(context, 0, items);
        sSectionID = sectionID;
        sCloserItemsIDs = closerItemsIDs;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_format2, parent, false);
        }
        currentLondonRunnerItem = getItem(position);

        TextView nameTV = listItemView.findViewById(R.id.item_name);
        assert currentLondonRunnerItem != null;
        nameTV.setText(currentLondonRunnerItem.getName());

        variableTV = listItemView.findViewById(R.id.item_location);
        setTextToLocationTV(sSectionID, sCloserItemsIDs);

        imageV = listItemView.findViewById(R.id.image);
        setImagetoImageV(sSectionID);

        textContainer = listItemView.findViewById(R.id.text_container);
        setItemListener(sCloserItemsIDs, position);

        return listItemView;
    }

    private void setTextToLocationTV(int sSectionID, int[] sCloserItemsIDs) {

        if (sCloserItemsIDs.length == 1 && sSectionID != CLUBS_ID) {
            String itemLocation = "Zone: " + currentLondonRunnerItem.getVariable();
            variableTV.setText(itemLocation);
            return;
        }

        if (sCloserItemsIDs.length > 1) {        //List of tracks in terms of distance is called
            variableTV.setText(currentLondonRunnerItem.getVariable());  //So distance to user is displayed
            return;
        }
        if (sSectionID == CLUBS_ID) {
            String itemLocation = currentLondonRunnerItem.getVariable();
            variableTV.setText(itemLocation);
        }
    }

    private void setImagetoImageV(int sSectionID) {

        if (sSectionID == CLUBS_ID) { //if clubs, set fixed image size
            imageV.getLayoutParams().height = 650;
            imageV.requestLayout();

        }

        String x = currentLondonRunnerItem.getImageId() + ".png";
        Picasso.with(getContext())
                .load(x)
                .into(imageV);
    }

    private void setItemListener(int[] sCloserItemsIDs, int position) {
        textContainer.setBackgroundColor(getContext().getResources().getColor(R.color.transp_bg));

        int itemID = position;
        if (sCloserItemsIDs.length > 1) {
            itemID = sCloserItemsIDs[position];
            //ensures the container onclicklistener redirects user to correct ID
            //if not a "distance from user" display, then position is itemID
            //if "distance from user" display, itemID needs to be corrected (won't be position)
        }
        textContainer.setOnClickListener(new loadNewDetailedItemLayout(sSectionID, itemID,getContext()));
    }

}
