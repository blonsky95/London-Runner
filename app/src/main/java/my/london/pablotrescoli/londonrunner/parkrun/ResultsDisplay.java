package my.london.pablotrescoli.londonrunner.parkrun;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import my.london.pablotrescoli.londonrunner.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.ref.WeakReference;

public class ResultsDisplay extends AppCompatActivity {

    TextView txtView;
    TextView titleTV;
    String resultsURL;
    private ProgressDialog progress;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parkrun_res);

        setTitle("Results");
        setAndDesignToolbar();

        Intent intent = getIntent();
        resultsURL = intent.getStringExtra("resultsURL");

        txtView = findViewById(R.id.htmltext);
        titleTV = findViewById(R.id.titleTV);

        showProgressDialog();

        new getHTML(this).execute();
    }

    private void showProgressDialog() {
        progress = new ProgressDialog(this);
        progress.setTitle("Loading Results");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();
    }

    public static class getHTML extends AsyncTask<Void, Void, Void> {

        private WeakReference<ResultsDisplay> activityReference;

        getHTML(ResultsDisplay context) {
            activityReference=new WeakReference<>(context);
        }

        String htmltext;
        String titleText;
        StringBuilder builder = new StringBuilder();


        @Override
        protected Void doInBackground(Void... voids) {
            org.jsoup.nodes.Document doc;


            try {
                doc = Jsoup.connect(activityReference.get().resultsURL).get();
                htmltext = doc.text();

                Element athleteName = doc.select("h2").first();
                builder.append("Athlete Name:\n").append(athleteName.text());
                titleText = builder.toString();
                builder = new StringBuilder();

                Element tableBody = doc.select("tbody").first();
                Elements tableRows = tableBody.select("tr");
                for (Element tableRow : tableRows) {
                    Element columnDate = tableRow.select("td").get(1);
                    builder.append("\n\nDate of run: ").append(columnDate.text());
                    Element columnLocation = tableRow.select("td").get(0);
                    builder.append("\nLocation: ").append(columnLocation.text());
                    Element columnTime = tableRow.select("td").get(4);
                    builder.append("\nTime: ").append(columnTime.text());
                    Element columnGenderP = tableRow.select("td").get(2);
                    builder.append("\nGender Position: ").append(columnGenderP.text());
                    Element columnOverallP = tableRow.select("td").get(3);
                    builder.append("\nOverall Position: ").append(columnOverallP.text());
                    Element columnAgeGrade = tableRow.select("td").get(5);
                    builder.append("\nAge Grade: ").append(columnAgeGrade.text());

                }

            } catch (IOException e) {
                builder.append("Error : ").append(e.getMessage()).append("\n");
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void avoid) {
            super.onPostExecute(avoid);
            String resultsStr = builder.toString();
            if (resultsStr.isEmpty()) {
                resultsStr = "\n\nNo Parkruns registered";
            }
            activityReference.get().txtView.setText(resultsStr);

            String name_mod = modStr(titleText);
            activityReference.get().titleTV.setText(name_mod);
            activityReference.get().progress.dismiss();
        }


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

    private static String modStr(String titleText) {
        if (titleText.contains("(")) {
            return titleText.substring(0, titleText.indexOf("(") - 1);
        }
        return titleText;
    }

}
