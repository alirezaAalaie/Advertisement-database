package com.example.restapi.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CampaignDto implements Serializable {

    @JsonProperty(required = false)
    private int campaignID=1 ;

    @JsonProperty(required = false)
    private int advertiserID;


    private String name;
    private String startDate;

    private String endDate;
    private int budget;

    public CampaignDto (int campaignID , int advertiserID , String name , String statDate , String endDate , int budget) {
        this.campaignID = campaignID;
        this.advertiserID = advertiserID;
        this.name = name;
        this.startDate = statDate;
        this.endDate = endDate;
        this.budget = budget;
    }

    public CampaignDto ( int advertiserID , String name , String statDate , String endDate , int budget) {
        this.advertiserID = advertiserID;
        this.name = name;
        this.startDate = statDate;
        this.endDate = endDate;
        this.budget = budget;
    }

    public CampaignDto ( String name , String statDate , String endDate , int budget) {
        this.name = name;
        this.startDate = statDate;
        this.endDate = endDate;
        this.budget = budget;
    }
    public CampaignDto () {

    }



    public int getCampaignID () {
        return campaignID;
    }

    public void setCampaignID (int campaignID) {
        this.campaignID = campaignID;
    }

    public int getAdvertiserID () {
        return advertiserID;
    }

    public void setAdvertiserID (int advertiserID) {
        this.advertiserID = advertiserID;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getStartDate () {
        return startDate;
    }

    public void setStartDate (String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate () {
        return endDate;
    }

    public void setEndDate (String endDate) {
        this.endDate = endDate;
    }

    public int getBudget () {
        return budget;
    }

    public void setBudget (int budget) {
        this.budget = budget;
    }

    public Campaign toCampaign(){
        return new Campaign ( campaignID,advertiserID,name, startDate,endDate,budget );
    }

    @Override
    public String toString () {
        return "CampaignDto{" +
                "campaignID=" + campaignID +
                ", advertiserID=" + advertiserID +
                ", name='" + name + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", budget=" + budget +
                '}';
    }
}

