package my.london.pablotrescoli.londonrunner.clubs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ListView;

import my.london.pablotrescoli.londonrunner.R;
import my.london.pablotrescoli.londonrunner.main.LondonRunnerItem;
import my.london.pablotrescoli.londonrunner.main.LondonRunnerItemAdapter;

import java.util.ArrayList;

public class AthleticsClubsDisplay extends AppCompatActivity {

    int SITE_ID = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outdoortracks);
        setTitle("Athletics Clubs");

        setAndDesignToolbar();

        final ArrayList<LondonRunnerItem> items = new ArrayList<>();
        String [] itemClubName=getResources().getStringArray(R.array.club_name);
        String [] itemClubTrack=getResources().getStringArray(R.array.club_track);
        String [] itemClubPicURL=getResources().getStringArray(R.array.club_picture_URL);

        for (int i=0; i<itemClubName.length;i++){
            items.add(new LondonRunnerItem(itemClubName[i],itemClubTrack[i],itemClubPicURL[i]));
        }

        int[] fiveClosestIds = {-1};

        LondonRunnerItemAdapter adapter = new LondonRunnerItemAdapter(this, items, SITE_ID,fiveClosestIds);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

    }

    private void setAndDesignToolbar() {
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
            setSupportActionBar(myToolbar);
            if (getSupportActionBar()!=null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);

                myToolbar.setBackgroundColor(getResources().getColor(R.color.actionbar_bg));
                myToolbar.setTitleTextColor(getResources().getColor(R.color.white)); //
                myToolbar.setNavigationIcon(R.drawable.back_icon);
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
