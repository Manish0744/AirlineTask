package com.rest.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.main.entity.CustomerInfo;

public interface CustomerRepository extends JpaRepository<CustomerInfo, Long> {

}
