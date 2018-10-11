package com.example.pablotrescoli.londonrunner.main;

public class LondonRunnerItem {
    private String sName;
    private String sVariable;
    private String sImageId;

    public LondonRunnerItem(String Name, String Variable, String ImageId) {
        sName = Name;
        sVariable = Variable; //location for non distance item tracks & clubs, distance for distance item tracks,
        sImageId = ImageId;
    }


    public String getName() {
        return sName;
    }

    public String getVariable() {
        return sVariable;
    }

    public String getImageId() {
        return sImageId;
    }


}
