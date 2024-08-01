package com.example.restapi.controller;


import com.example.restapi.model.CampaignDto;
import com.example.restapi.model.PerformanceDto;
import com.example.restapi.service.CampaignServiceImp;
import com.example.restapi.service.PerformanceServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/api/Performance")
public class PerformanceRestController {

    private final PerformanceServiceImp performanceServiceImp;

    @Autowired
    public PerformanceRestController (PerformanceServiceImp performanceServiceImp) {

        this.performanceServiceImp = performanceServiceImp;
    }

    @GetMapping("")
    public ResponseEntity<List<PerformanceDto>> getAllPerformance (){

        return ResponseEntity.ok (performanceServiceImp.getAll ());

    }


    @GetMapping("/{id}")
    public ResponseEntity<PerformanceDto> getPerformance(@PathVariable int id) {
        try {
            return ResponseEntity.ok(performanceServiceImp.getPerformanceById ( id ));

        }catch (Exception e){
            return ResponseEntity.ok(null);
        }

    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PerformanceDto> createPerformance(@RequestBody PerformanceDto performanceDto) {

        return ResponseEntity.ok(performanceServiceImp.createPerformance ( performanceDto ));
    }


}

