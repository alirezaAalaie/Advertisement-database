package com.example.restapi.controller;

import com.example.restapi.model.AdvertiserDto;
import com.example.restapi.model.BillDto;
import com.example.restapi.service.AdvertiseServiceImp;
import com.example.restapi.service.BillServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/api/Bill")
public class BillRestController {


        private final BillServiceImp billServiceImp;

        @Autowired
        public BillRestController (BillServiceImp billServiceImp) {

            this.billServiceImp=billServiceImp;
        }

        @GetMapping("")
        public ResponseEntity<List<BillDto>> getAllBill (){

            return ResponseEntity.ok (billServiceImp.getAll ());

        }


        @GetMapping("/{id}")
        public ResponseEntity<BillDto> getBill(@PathVariable int id) {
            try {
                return ResponseEntity.ok(billServiceImp.getBillById ( id ));

            }catch (Exception e){
                return ResponseEntity.ok(null);
            }

        }

        @PostMapping("/create")
        @ResponseStatus(HttpStatus.CREATED)
        public ResponseEntity<BillDto> createBill(@RequestBody    BillDto billDto) {
            return ResponseEntity.ok(billServiceImp.createBill ( billDto ));
        }

        @PutMapping("/{id}/update")
        public ResponseEntity<BillDto> updateBill(@RequestBody  BillDto billDto
                , @PathVariable("id") int currentId) {
            return ResponseEntity.ok(billServiceImp.updateBill ( currentId,billDto ));
        }

        @DeleteMapping("/{id}/delete")
        public ResponseEntity<String> deleteBill(@PathVariable int id) {
            try {
                billServiceImp.deleteBillById ( id );
                return ResponseEntity.ok("Deleted");

            }catch (Exception e){
                return ResponseEntity.ok(e.getMessage ());
            }
        }
    }

