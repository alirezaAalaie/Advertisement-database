package com.example.restapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Data
@Entity
@Table(name = "bills",schema = "internetadvertisement")
public class Bill implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "bill_id", unique = true)
    private int billID;

    @Column(name = "campaign_id")
    private int campaignID;

    @Column(name = "advertiser_id")
    private int advertiserID;
    @Column(name = "bill_rate")
    private double billRate;
    @Column(name = "bill_amount")
    private int billAmount;
    @Column(name = "bill_status")
    private String billStatus;
    @Column(name = "dateissued")
    private String dataIssued;

    public Bill (int billID , int campaignID , int advertiserID , double billRate , int billAmount , String billStatus , String dataIssued) {
        this.billID = billID;
        this.campaignID = campaignID;
        this.advertiserID = advertiserID;
        this.billRate = billRate;
        this.billAmount = billAmount;
        this.billStatus = billStatus;
        this.dataIssued = dataIssued;
    }

    public Bill () {

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

    public void setBillRate (double billRate) {
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

    public String getDataIssued () {
        return dataIssued;
    }

    public void setDataIssued (String dataIssued) {
        this.dataIssued = dataIssued;
    }

    public BillDto toBillDto(){
        return new BillDto (this.billID,
                this.campaignID,this.advertiserID,this.billRate,this.billAmount,this.billStatus,dataIssued);
    }

}
