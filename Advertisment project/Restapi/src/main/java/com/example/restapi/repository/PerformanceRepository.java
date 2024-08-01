package com.example.restapi.repository;

import com.example.restapi.model.Advertiser;
import com.example.restapi.model.Performance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceRepository extends JpaRepository<Performance,Integer> {
}
