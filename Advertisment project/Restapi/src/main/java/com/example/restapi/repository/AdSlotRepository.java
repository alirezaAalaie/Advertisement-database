package com.example.restapi.repository;

import com.example.restapi.model.AdSlot;
import com.example.restapi.model.Advertiser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdSlotRepository extends JpaRepository<AdSlot,Integer> {
}
