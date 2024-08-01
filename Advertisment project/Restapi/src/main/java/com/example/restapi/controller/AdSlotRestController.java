package com.example.restapi.controller;

import com.example.restapi.model.AdSlotDto;
import com.example.restapi.model.AdvertiserDto;
import com.example.restapi.service.AdSlotServiceImp;
import com.example.restapi.service.AdvertiseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/api/AdSlot")
public class AdSlotRestController {

    private final AdSlotServiceImp adSlotServiceImp;

    @Autowired
    public AdSlotRestController (AdSlotServiceImp adSlotServiceImp) {

        this.adSlotServiceImp=adSlotServiceImp;
    }

    @GetMapping("")
    public ResponseEntity<List<AdSlotDto>> getAllAdSlot (){

        return ResponseEntity.ok (adSlotServiceImp.getAll ());

    }


    @GetMapping("/{id}")
    public ResponseEntity<AdSlotDto> getAdSlot(@PathVariable int id) {
        try {
            return ResponseEntity.ok(adSlotServiceImp.getAdSlotById ( id ));

        }catch (Exception e){
            return ResponseEntity.ok(null);
        }

    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AdSlotDto> createAdSlot(@RequestBody AdSlotDto adSlotDto
) {

        return ResponseEntity.ok(adSlotServiceImp.createAdSlot ( adSlotDto ));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<AdSlotDto> updateAdSlot(@RequestBody  AdSlotDto adSlotDto,
                                                          @PathVariable("id") int currentId) {

        return ResponseEntity.ok(adSlotServiceImp.updateAdSlot ( currentId,adSlotDto ));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteAdSlot(@PathVariable int id) {
        try {
            adSlotServiceImp.deleteAdSlotById ( id );
            return ResponseEntity.ok("Deleted");

        }catch (Exception e){
            return ResponseEntity.ok(e.getMessage ());
        }
    }
}
