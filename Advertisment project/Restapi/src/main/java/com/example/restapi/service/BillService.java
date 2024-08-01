package com.example.restapi.service;

import com.example.restapi.model.AdvertiserDto;
import com.example.restapi.model.BillDto;

import java.util.List;

public interface BillService {

    List<BillDto> getAll();
    BillDto getBillById (int id) throws Exception;
    BillDto createBill(BillDto billDto);

    BillDto updateBill(int id,BillDto billDto) ;
    void deleteBillById(int id) throws Exception;

}
