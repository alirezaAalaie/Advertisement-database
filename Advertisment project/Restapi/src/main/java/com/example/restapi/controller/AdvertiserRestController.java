package com.example.restapi.controller;

import com.example.restapi.model.AdvertiserDto;
import com.example.restapi.service.AdvertiseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/api/Advertisers")
public class AdvertiserRestController {

    private final AdvertiseServiceImp advertiseServiceImp;

    @Autowired
    public AdvertiserRestController (AdvertiseServiceImp advertiseServiceImp) {

        this.advertiseServiceImp = advertiseServiceImp;
    }

    @GetMapping("")
    public ResponseEntity<List<AdvertiserDto>> getAllAdvertiser (){

        return ResponseEntity.ok (advertiseServiceImp.getAll ());

    }


    @GetMapping("/{id}")
    public ResponseEntity<AdvertiserDto> getAdvertiser(@PathVariable int id) {
        try {
            return ResponseEntity.ok(advertiseServiceImp.getAdvertiserById (  id ));

        }catch (Exception e){
            return ResponseEntity.ok(null);
        }

    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AdvertiserDto> createAdvertiser(@RequestBody  AdvertiserDto advertiserDto){


        return ResponseEntity.ok(advertiseServiceImp.createAdvertiser ( advertiserDto ));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<AdvertiserDto> updateAdvertiser(@RequestBody AdvertiserDto advertiserDto, @PathVariable("id") int currentId) {
        return ResponseEntity.ok(advertiseServiceImp.updateAdvertiser ( currentId,advertiserDto ));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteAdvertiser(@PathVariable int id) {
        try {
            advertiseServiceImp.deleteAdvertiserById (  id );
            return ResponseEntity.ok("Deleted");

        }catch (Exception e){
            return ResponseEntity.ok(e.getMessage ());
        }
    }
}

