package com.example.restapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class BillDto implements Serializable {

    @JsonProperty(required = false)

    private int billID;
    @JsonProperty(required = false)

    private int campaignID;
    @JsonProperty(required = false)

    private int advertiserID;


    private double billRate;
    private int billAmount;
    private String billStatus;
    private String dataIssued;

    public BillDto (int billID , int campaignID , int advertiserID , double billRate , int billAmount , String billStatus,String dataIssued) {
        this.billID = billID;
        this.campaignID = campaignID;
        this.advertiserID = advertiserID;
        this.billRate = billRate;
        this.billAmount = billAmount;
        this.billStatus = billStatus;
        this.dataIssued=dataIssued;
    }
    public BillDto ( int campaignID , int advertiserID , float billRate , int billAmount , String billStatus,String dataIssued) {
        this.billID = 0;
        this.campaignID = campaignID;
        this.advertiserID = advertiserID;
        this.billRate = billRate;
        this.billAmount = billAmount;
        this.billStatus = billStatus;
        this.dataIssued=dataIssued;
    }
    public BillDto ( float billRate , int billAmount , String billStatus,String dataIssued) {
        this.billID = 0;
        this.campaignID = 0;
        this.advertiserID = 0;
        this.billRate = billRate;
        this.billAmount = billAmount;
        this.billStatus = billStatus;
        this.dataIssued=dataIssued;
    }


    public BillDto () {

    }

    public String getDataIssued () {
        return dataIssued;
    }

    public void setDataIssued (String dataIssued) {
        this.dataIssued = dataIssued;
    }

    public int getBillID () {
        return billID;
    }

    public void setBillID (int billID) {
        this.billID = billID;
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

    public double getBillRate () {
        return billRate;
    }

    public void setBillRate (float billRate) {
        this.billRate = billRate;
    }

    public int getBillAmount () {
        return billAmount;
    }

    public void setBillAmount (int billAmount) {
        this.billAmount = billAmount;
    }

    public String getBillStatus () {
        return billStatus;
    }

    public void setBillStatus (String billStatus) {
        this.billStatus = billStatus;
    }

    public Bill toBill(){
        return new Bill (this.billID,
                this.campaignID,this.advertiserID,this.billRate,this.billAmount,this.billStatus,dataIssued);
    }

    @Override
    public String toString () {
        return "BillDto{" +
                "billID=" + billID +
                ", campaignID=" + campaignID +
                ", advertiserID=" + advertiserID +
                ", billRate=" + billRate +
                ", billAmount=" + billAmount +
                ", billStatus='" + billStatus + '\'' +
                '}';
    }
}
