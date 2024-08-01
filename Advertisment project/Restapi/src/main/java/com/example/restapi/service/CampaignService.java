package com.example.restapi.service;

import com.example.restapi.model.CampaignDto;

import java.util.List;

public interface CampaignService {
    List<CampaignDto> getAll();
    CampaignDto getCampaignById (int id) throws Exception;
    CampaignDto createCampaign(CampaignDto campaignDto);

    CampaignDto updateCampaign(int id,CampaignDto campaignDto) ;
    void deleteCampaignById(int id) throws Exception;

}
