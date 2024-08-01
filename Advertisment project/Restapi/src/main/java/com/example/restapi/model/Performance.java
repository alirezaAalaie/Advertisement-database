package com.example.restapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "performance", schema = "internetadvertisement")
public class Performance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "campaign_id" , unique = true)
    private int campaignID;
    @Column(name = "impressions")
    private int impressions;

    @Column(name = "clicks")
    private int clicks;

    @Column(name = "successful_clicks")
    private int successfulClicks;

    public Performance (int campaignID , int impressions , int clicks , int successfulClicks) {
        this.campaignID = campaignID;
        this.impressions = impressions;
        this.clicks = clicks;
        this.successfulClicks = successfulClicks;
    }
    public Performance(){

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

    public PerformanceDto toPerformanceDto(){
        return new PerformanceDto (campaignID,impressions,clicks,successfulClicks);
    }
}