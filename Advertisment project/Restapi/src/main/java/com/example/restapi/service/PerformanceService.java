package com.example.restapi.service;

import com.example.restapi.model.AdvertiserDto;
import com.example.restapi.model.PerformanceDto;

import java.util.List;

public interface PerformanceService {
    List<PerformanceDto> getAll();
    PerformanceDto getPerformanceById (int id) throws Exception;
    PerformanceDto createPerformance(PerformanceDto performanceDto);

}
