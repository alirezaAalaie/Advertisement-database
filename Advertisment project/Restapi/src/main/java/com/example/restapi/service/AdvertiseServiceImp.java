package com.example.restapi.service;

import com.example.restapi.model.Advertiser;
import com.example.restapi.model.AdvertiserDto;
import com.example.restapi.repository.AdvertiserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdvertiseServiceImp implements AdvertiseService {

    private AdvertiserRepository advertiserRepository;

    @Autowired
    public AdvertiseServiceImp (AdvertiserRepository advertiserRepository){
        this.advertiserRepository =advertiserRepository;
    }

    @Override
    public List<AdvertiserDto> getAll () {
        List<Advertiser> advertisers=advertiserRepository.findAll ();
        return advertisers.stream().map(Advertiser::toAdvertiserDto).collect( Collectors.toList());
    }

    @Override
    public AdvertiserDto getAdvertiserById (int id) throws Exception {
        if(advertiserRepository.findById ( id ).isPresent ()) {
            return advertiserRepository.findById ( id ).get ().toAdvertiserDto ();
        }else {
            throw new Exception("Advertiser By this id " + id + "does not exist");
        }

    }

    @Override
    public AdvertiserDto createAdvertiser (AdvertiserDto advertiserDto) {
        Advertiser advertiser=advertiserDto.toAdvertiser ();
        return advertiserRepository.save ( advertiser ).toAdvertiserDto ();

    }

    @Override
    public AdvertiserDto updateAdvertiser (int id , AdvertiserDto advertiserDto) {
        if(advertiserRepository.findById ( id ).isPresent ()) {
            Advertiser advertiser = advertiserRepository.findById ( id ).get ();
            advertiser.setName ( advertiserDto.getName () );
            advertiser.setContactInfo ( advertiserDto.getContactInfo () );
            advertiser.setIndustryType ( advertiserDto.getIndustryType () );

            return advertiserRepository.save ( advertiser ).toAdvertiserDto ();
        }else {
            Advertiser advertiser=advertiserDto.toAdvertiser ();
            return advertiserRepository.save ( advertiser ).toAdvertiserDto ();

        }

    }

    @Override
    public void deleteAdvertiserById (int id) throws Exception {
        if(advertiserRepository.findById ( id ).isPresent ()) {
            advertiserRepository.delete ( advertiserRepository.findById ( id ).get () );
        }else {
            throw new Exception("Advertiser By this id " + id + "does not exist");
        }
    }
}
