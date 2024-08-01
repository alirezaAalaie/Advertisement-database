package com.example.restapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class PerformanceDto implements Serializable {

    @JsonProperty(required = false)

    private int campaignID;
    private int impressions;

    private int clicks;

    private int successfulClicks;

    public PerformanceDto (int campaignID , int impressions , int clicks , int successfulClicks) {
        this.campaignID = campaignID;
        this.impressions = impressions;
        this.clicks = clicks;
        this.successfulClicks = successfulClicks;
    }
    public PerformanceDto(){

    }

    public int getCampaignID () {
        return campaignID;
    }

    public void setCampaignID (int campaignID) {
        this.campaignID = campaignID;
    }

    public int getImpressions () {
        return impressions;
    }

    public void setImpressions (int impressions) {
        this.impressions = impressions;
    }

    public int getClicks () {
        return clicks;
    }

    public void setClicks (int clicks) {
        this.clicks = clicks;
    }

    public int getSuccessfulClicks () {
        return successfulClicks;
    }

    public void setSuccessfulClicks (int successfulClicks) {
        this.successfulClicks = successfulClicks;
    }

    public Performance toPerformance(){
        return new Performance (campaignID,impressions,clicks,successfulClicks);
    }

    @Override
    public String toString () {
        return "PerformanceDto{" +
                "campaignID=" + campaignID +
                ", impressions=" + impressions +
                ", clicks=" + clicks +
                ", successfulClicks=" + successfulClicks +
                '}';
    }
}
