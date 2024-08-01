package com.example.restapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Data
@Entity
@Table (name = "advertisers",schema = "internetadvertisement")
public class Advertiser implements Serializable{

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        @Column(name = "advertiser_id" , unique = true)
        private int advertiserID;
        @Column(name = "name")
         private String name;

        @Column(name = "contact_info")
        private String contactInfo;

        @Column(name = "industry_type")
        private String industryType;

    public Advertiser (int advertiserID , String name , String contactInfo , String industryType) {
        this.advertiserID = advertiserID;
        this.name = name;
        this.contactInfo = contactInfo;
        this.industryType = industryType;
    }


    public Advertiser(){

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

        public AdvertiserDto toAdvertiserDto(){
            return new AdvertiserDto ( this.advertiserID ,this.name,contactInfo,industryType);
        }



}
