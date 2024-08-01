package com.example.restapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table (name = "campaign" , schema = "internetadvertisement")
public class Campaign implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column (name = "campaign_id" , unique = true)
    private int campaignID;
    @Column(name = "advertiser_id")
    private int advertiserID;
    @Column(name = "name")
    private String name;
    @Column(name = "start_date")
    private String startDate;
    @Column(name = "end_date")
    private String endDate;
    @Column(name = "budget")
    private int budget;

    public Campaign (int campaignID , int advertiserID , String name , String statDate , String endDate , int budget) {
        this.campaignID = campaignID;
        this.advertiserID = advertiserID;
        this.name = name;
        this.startDate = statDate;
        this.endDate = endDate;
        this.budget = budget;
    }

    public Campaign () {

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

    public CampaignDto toCampaignDto(){
        return new CampaignDto ( campaignID,advertiserID,name, startDate,endDate,budget );
    }

}

