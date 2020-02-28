package com.ishan.allocater.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ishan.allocater.model.Allocation;

public interface AllocationRepository extends JpaRepository<Allocation, Integer> {

}
