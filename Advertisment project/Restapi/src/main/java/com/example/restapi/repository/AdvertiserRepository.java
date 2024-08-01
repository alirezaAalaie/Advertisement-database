package com.example.restapi.repository;

import com.example.restapi.model.Advertiser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertiserRepository extends JpaRepository<Advertiser,Integer> {
}
