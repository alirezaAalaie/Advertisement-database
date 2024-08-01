package com.example.restapi.service;

import com.example.restapi.model.AdvertiserDto;

import java.util.List;

public interface AdvertiseService {

        List<AdvertiserDto> getAll();
        AdvertiserDto getAdvertiserById (int id) throws Exception;
        AdvertiserDto createAdvertiser(AdvertiserDto advertiserDto);

        AdvertiserDto updateAdvertiser(int id,AdvertiserDto advertiserDto) ;
        void deleteAdvertiserById(int id) throws Exception;


}
