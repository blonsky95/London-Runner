package my.london.pablotrescoli.londonrunner.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import my.london.pablotrescoli.londonrunner.R;
import my.london.pablotrescoli.londonrunner.clubs.AthleticsClubsDisplay;

public class MainMenu extends AppCompatActivity {

    final int TRACKS_ID = 1;
    final int CLUBS_ID = 2;
    final int PARKRUN_ID = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tracksTextView = findViewById(R.id.text1);
        tracksTextView.setOnClickListener(new goSection(TRACKS_ID));

        TextView clubsTextView = findViewById(R.id.text4);
        clubsTextView.setOnClickListener(new goSection(CLUBS_ID));

        TextView parkrunTextView = findViewById(R.id.text5);
        parkrunTextView.setOnClickListener(new goSection(PARKRUN_ID));
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
                case TRACKS_ID:
                    intent = new Intent(MainMenu.this, TracksMenu.class);
                    break;
                case CLUBS_ID:
                    intent = new Intent(MainMenu.this, AthleticsClubsDisplay.class);
                    break;
                case PARKRUN_ID:
                    intent = new Intent(MainMenu.this, ParkrunMenu.class);
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
}
