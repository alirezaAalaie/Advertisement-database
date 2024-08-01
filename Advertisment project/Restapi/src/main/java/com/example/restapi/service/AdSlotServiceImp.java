package com.example.restapi.service;

import com.example.restapi.model.AdSlot;
import com.example.restapi.model.AdSlotDto;
import com.example.restapi.model.Advertiser;
import com.example.restapi.repository.AdSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdSlotServiceImp implements AdSlotService{

    private AdSlotRepository adSlotRepository;

    @Autowired
    public AdSlotServiceImp (AdSlotRepository adSlotRepository){
        this.adSlotRepository=adSlotRepository;
    }


    @Override
    public List<AdSlotDto> getAll () {
        List<AdSlot> adSlots=adSlotRepository.findAll ();
        return adSlots.stream().map( AdSlot::toAdSlotDto).collect( Collectors.toList());

    }

    @Override
    public AdSlotDto getAdSlotById (int id) throws Exception {
        if(adSlotRepository.findById ( id ).isPresent ()) {
            return adSlotRepository.findById ( id ).get ().toAdSlotDto ();
        }else {
            throw new Exception("AdSlot By this id " + id + "does not exist");
        }

    }

    @Override
    public AdSlotDto createAdSlot (AdSlotDto adSlotDto) {
        AdSlot adSlot=adSlotDto.toAdSlot ();
        return adSlotRepository.save ( adSlot ).toAdSlotDto ();

    }

    @Override
    public AdSlotDto updateAdSlot (int id , AdSlotDto adSlotDto) {
        if(adSlotRepository.findById ( id ).isPresent ()) {
            AdSlot adSlot = adSlotRepository.findById ( id ).get ();
            adSlot.setSlotDimension ( adSlotDto.getSlotDimension () );
            adSlot.setSlotLocation ( adSlotDto.getSlotLocation () );
            adSlot.setSlotType ( adSlotDto.getSlotType () );
            adSlot.setNumberOfAds ( adSlotDto.getNumberOfAds () );

            return adSlotRepository.save ( adSlot ).toAdSlotDto ();
        }else {
            AdSlot adSlot=adSlotDto.toAdSlot ();
            return adSlotRepository.save ( adSlot ).toAdSlotDto ();

        }
    }

    @Override
    public void deleteAdSlotById (int id) throws Exception {
        if(adSlotRepository.findById ( id ).isPresent ()) {
            adSlotRepository.delete ( adSlotRepository.findById ( id ).get () );
        }else {
            throw new Exception("AdSlot By this id " + id + "does not exist");
        }

    }
}
