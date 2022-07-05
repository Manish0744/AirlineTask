package com.rest.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.main.entity.AirlineInfo;

public interface AirlineRepository extends JpaRepository<AirlineInfo, Long> {

}
