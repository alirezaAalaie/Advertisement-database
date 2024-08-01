package com.example.restapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class AdvertiserDto implements Serializable {

    @JsonProperty(required = false)
    private int advertiserID;
    private String name;
    private String contactInfo;
    private String industryType;

    public AdvertiserDto (int advertiserID , String name , String contactInfo , String industryType) {
        this.advertiserID = advertiserID;
        this.name = name;
        this.contactInfo = contactInfo;
        this.industryType = industryType;
    }

    public AdvertiserDto ( String name , String contactInfo , String industryType) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.industryType = industryType;
        this.advertiserID=0;
    }

    public AdvertiserDto(){

    }
    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getAdvertiserID () {
        return advertiserID;
    }

    public void setAdvertiserID (int advertiserID) {
        this.advertiserID = advertiserID;
    }

    public String getContactInfo () {
        return contactInfo;
    }

    public void setContactInfo (String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getIndustryType () {
        return industryType;
    }

    public void setIndustryType (String industryType) {
        this.industryType = industryType;
    }

        public Advertiser toAdvertiser() {
            return new Advertiser ( this.advertiserID , this.name , this.contactInfo,industryType );
        }

    @Override
    public String toString () {
        return "AdvertiserDto{" +
                "advertiserID=" + advertiserID +
                ", name='" + name + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", industryType='" + industryType + '\'' +
                '}';
    }
}



