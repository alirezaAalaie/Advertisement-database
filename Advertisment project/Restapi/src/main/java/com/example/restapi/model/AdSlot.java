package com.example.restapi.model;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "ad_slot",schema = "internetadvertisement")
public class AdSlot implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "slot_id" , unique = true)
    private int adSlotID;
    @Column(name = "website_id")
    private int webID;
    @Column(name = "slot_location")
    private String slotLocation;

    @Column(name = "slot_dimension")
    private String slotDimension;

    @Column(name = "number_of_ads")
    private int numberOfAds;

    @Column(name = "slot_type")
    private String slotType;


    public AdSlot (int adSlotID , int webIID , String slotLocation , String slotDimension , int numberOfAds , String slotType) {
        this.adSlotID = adSlotID;
        this.webID = webIID;
        this.slotLocation = slotLocation;
        this.slotDimension = slotDimension;
        this.numberOfAds = numberOfAds;
        this.slotType = slotType;
    }

    public AdSlot () {

    }

    public int getAdSlotID () {
        return adSlotID;
    }

    public void setAdSlotID (int adSlotID) {
        this.adSlotID = adSlotID;
    }

    public int getWebID () {
        return webID;
    }

    public void setWebID (int webID) {
        this.webID = webID;
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


    public AdSlotDto toAdSlotDto(){
        return new AdSlotDto (this.adSlotID,this.webID ,this.slotLocation,this.slotDimension,numberOfAds,slotType);
    }
}