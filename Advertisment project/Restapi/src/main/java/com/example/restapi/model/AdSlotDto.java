package com.example.restapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


public class AdSlotDto implements Serializable {

    @JsonProperty(required = false)
    private int adSlotID;

    @JsonProperty(required = false)
    private int webIID;

    private String slotLocation;

    private String slotDimension;
    private int numberOfAds;
    private String slotType;

    public AdSlotDto (int adSlotID , int webIID , String slotLocation , String slotDimension , int numberOfAds , String slotType) {
        this.adSlotID = adSlotID;
        this.webIID = webIID;
        this.slotLocation = slotLocation;
        this.slotDimension = slotDimension;
        this.numberOfAds = numberOfAds;
        this.slotType = slotType;
    }
    public AdSlotDto ( int webIID , String slotLocation , String slotDimension , int numberOfAds , String slotType) {
        this.adSlotID = 0;
        this.webIID = webIID;
        this.slotLocation = slotLocation;
        this.slotDimension = slotDimension;
        this.numberOfAds = numberOfAds;
        this.slotType = slotType;
    }
    public AdSlotDto (  String slotLocation , String slotDimension , int numberOfAds , String slotType) {
        this.adSlotID = 0;
        this.webIID = 0;
        this.slotLocation = slotLocation;
        this.slotDimension = slotDimension;
        this.numberOfAds = numberOfAds;
        this.slotType = slotType;
    }

    public AdSlotDto () {

    }

    public int getAdSlotID () {
        return adSlotID;
    }

    public void setAdSlotID (int adSlotID) {
        this.adSlotID = adSlotID;
    }

    public int getWebIID () {
        return webIID;
    }

    public void setWebIID (int webIID) {
        this.webIID = webIID;
    }

    public String getSlotLocation () {
        return slotLocation;
    }

    public void setSlotLocation (String slotLocation) {
        this.slotLocation = slotLocation;
    }

    public String getSlotDimension () {
        return slotDimension;
    }

    public void setSlotDimension (String slotDimension) {
        this.slotDimension = slotDimension;
    }

    public int getNumberOfAds () {
        return numberOfAds;
    }

    public void setNumberOfAds (int numberOfAds) {
        this.numberOfAds = numberOfAds;
    }

    public String getSlotType () {
        return slotType;
    }

    public void setSlotType (String slotType) {
        this.slotType = slotType;
    }

    @Override
    public String toString () {
        return "AdSlotDto{" +
                "adSlotID=" + adSlotID +
                ", webIID=" + webIID +
                ", slotLocation='" + slotLocation + '\'' +
                ", slotDimension='" + slotDimension + '\'' +
                ", numberOfAds=" + numberOfAds +
                ", slotType='" + slotType + '\'' +
                '}';
    }

    public AdSlot toAdSlot(){
        return new AdSlot (this.adSlotID,this.webIID,this.slotLocation,this.slotDimension,numberOfAds,slotType);
    }
}
