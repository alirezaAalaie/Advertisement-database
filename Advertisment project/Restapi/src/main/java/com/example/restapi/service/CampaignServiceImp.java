package com.example.restapi.service;

import com.example.restapi.model.Advertiser;
import com.example.restapi.model.Campaign;
import com.example.restapi.model.CampaignDto;
import com.example.restapi.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CampaignServiceImp implements CampaignService{
    private CampaignRepository campaignRepository;

    @Autowired
    public CampaignServiceImp(CampaignRepository campaignRepository){
        this.campaignRepository =campaignRepository;
    }


    @Override
    public List<CampaignDto> getAll () {
        List<Campaign> campaigns=campaignRepository.findAll ();
        return campaigns.stream().map(Campaign::toCampaignDto).collect( Collectors.toList());

    }

    @Override
    public CampaignDto getCampaignById (int id) throws Exception {
        if(campaignRepository.findById ( id ).isPresent ()) {
            return campaignRepository.findById ( id ).get ().toCampaignDto ();
        }else {
            throw new Exception("Campaign By this id " + id + "does not exist");
        }
    }

    @Override
    public CampaignDto createCampaign (CampaignDto campaignDto) {
        Campaign campaign=campaignDto.toCampaign ();
//            System.out.println (campaign.toCampaignDto ());
//            return campaignDto;
        return campaignRepository.save ( campaign ).toCampaignDto ();
    }

    @Override
    public CampaignDto updateCampaign (int id , CampaignDto campaignDto)  {
        if(campaignRepository.findById ( id ).isPresent ()) {
            Campaign campaign = campaignRepository.findById ( id ).get ();
            campaign.setName ( campaignDto.getName () );
            campaign.setBudget ( campaignDto.getBudget () );
            campaign.setStartDate ( campaignDto.getStartDate () );
            campaign.setEndDate ( campaignDto.getEndDate () );

            return campaignRepository.save ( campaign ).toCampaignDto ();
        }else {
            Campaign campaign=campaignDto.toCampaign ();
            return campaignRepository.save ( campaign ).toCampaignDto ();

        }
    }

    @Override
    public void deleteCampaignById (int id) throws Exception {
        if(campaignRepository.findById ( id ).isPresent ()) {
            campaignRepository.delete ( campaignRepository.findById ( id ).get () );
        }else {
            throw new Exception("Campaign By this id " + id + "does not exist");
        }

    }
}
