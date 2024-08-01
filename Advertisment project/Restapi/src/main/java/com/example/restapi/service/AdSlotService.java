package com.example.restapi.service;

import com.example.restapi.model.AdSlotDto;

import java.util.List;

public interface AdSlotService {
    List<AdSlotDto> getAll();
    AdSlotDto getAdSlotById (int id) throws Exception;
    AdSlotDto createAdSlot(AdSlotDto adSlotDto);

    AdSlotDto updateAdSlot(int id,AdSlotDto adSlotDto) ;
    void deleteAdSlotById(int id) throws Exception;


}
