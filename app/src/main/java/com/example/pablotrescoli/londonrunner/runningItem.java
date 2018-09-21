package com.example.pablotrescoli.londonrunner;

public class runningItem {
    private int sName;
    private int sLocation;
    private int sPrice = NO_PRICE;
    private int sImageId;
    private String sDistance = NO_DISTANCE;
    private boolean hasDistance = false;


    private static final int NO_PRICE = -1;
    private static final String NO_DISTANCE = "-1";


    //for indoor and outdoor tracks
    public runningItem(int Name, int Location, int Price, int ImageId) {
        sName = Name;
        sLocation = Location;
        sPrice = Price;
        sImageId = ImageId;
    }
    // for sites displayed by distance
    public runningItem(int Name, int Location, String distance, int ImageId) {
        sName = Name;
        sLocation = Location;
        sDistance = distance;
        hasDistance = true;
        sImageId = ImageId;
    }

    //for running routes
    public runningItem(int Name, int Location, int ImageId) {
        sName = Name;
        sLocation = Location;
        sImageId = ImageId;
    }


    public int getName() {
        return sName;
    }

    public int getLocation() {
        return sLocation;
    }

    public int getPrice() {
        return sPrice;
    }

    public String getDistance() {
        return sDistance;
    }

    public int getImageId() {
        return sImageId;
    }

    public boolean isRunningRoute() {
        return (sPrice == NO_PRICE)&&(sDistance.matches(NO_DISTANCE));
    }

    public boolean hasDistance() {
        return !sDistance.matches(NO_DISTANCE);
    }


}
