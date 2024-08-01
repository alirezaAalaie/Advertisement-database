package com.example.restapi.controller;

import com.example.restapi.model.CampaignDto;
import com.example.restapi.service.CampaignServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/api/Campaign")
public class CampaignRestController {

    private final CampaignServiceImp campaignServiceImp;

    @Autowired
    public CampaignRestController (CampaignServiceImp campaignServiceImp) {

        this.campaignServiceImp = campaignServiceImp;
    }

    @GetMapping("")
    public ResponseEntity<List<CampaignDto>> getAllCampaign (){

        return ResponseEntity.ok (campaignServiceImp.getAll ());

    }


    @GetMapping("/{id}")
    public ResponseEntity<CampaignDto> getCampaign(@PathVariable int id) {
        try {
            return ResponseEntity.ok(campaignServiceImp.getCampaignById (   id ));

        }catch (Exception e){
            return ResponseEntity.ok(null);
        }

    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CampaignDto> createCampaign(@RequestBody  CampaignDto campaignDto) {
//        CampaignDto campaignDto=new CampaignDto (advertiserID,name,statDate,endDate,budget);

        return ResponseEntity.ok(campaignServiceImp.createCampaign ( campaignDto ));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<CampaignDto> updateCampaign(@RequestBody  CampaignDto campaignDto, @PathVariable("id") int currentId) {
//        CampaignDto campaignDto=new CampaignDto (name,statDate,endDate,budget);
        return ResponseEntity.ok(campaignServiceImp.updateCampaign ( currentId,campaignDto ));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteCampaign(@PathVariable int id) {
        try {
            campaignServiceImp.deleteCampaignById ( id );
            return ResponseEntity.ok("Deleted");

        }catch (Exception e){
            return ResponseEntity.ok(e.getMessage ());
        }
    }
}

