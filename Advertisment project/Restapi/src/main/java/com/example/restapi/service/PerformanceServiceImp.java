package com.example.restapi.service;

import com.example.restapi.model.Campaign;
import com.example.restapi.model.Performance;
import com.example.restapi.model.PerformanceDto;
import com.example.restapi.repository.CampaignRepository;
import com.example.restapi.repository.PerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PerformanceServiceImp implements PerformanceService{

    private PerformanceRepository performanceRepository;

    @Autowired
    public PerformanceServiceImp(PerformanceRepository performanceRepository){
        this.performanceRepository =performanceRepository;
    }



    @Override
    public List<PerformanceDto> getAll () {
        List<Performance> performances=performanceRepository.findAll ();
        return performances.stream().map(Performance::toPerformanceDto).collect( Collectors.toList());
    }

    @Override
    public PerformanceDto getPerformanceById (int id) throws Exception {
        if(performanceRepository.findById ( id ).isPresent ()) {
            return performanceRepository.findById ( id ).get ().toPerformanceDto ();
        }else {
            throw new Exception("Performance By this id " + id + "does not exist");
        }
    }

    @Override
    public PerformanceDto createPerformance (PerformanceDto performanceDto) {
        Performance  performance=performanceDto.toPerformance ();
        return performanceRepository.save ( performance ).toPerformanceDto ();

    }

}
