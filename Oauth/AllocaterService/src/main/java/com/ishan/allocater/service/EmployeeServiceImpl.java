package com.ishan.allocater.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.ishan.allocater.model.Allocation;
import com.ishan.allocater.repository.AllocationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	AllocationRepository employeeRepository;
	// DAO EKA

	@Override
	public List<Allocation> getAllocationList() {
		return employeeRepository.findAll();
	}

	@Override
	public Allocation save(Allocation allocation) {
		Allocation allocation1 = employeeRepository.save(allocation);
		return allocation1;
	}

	public List<Allocation> findAllocationsByEid(Integer Eid) {
		System.out.println("AllocaterService 1");
		// make empty
		Allocation emptyAllocationWithEid = new Allocation();
		emptyAllocationWithEid.setEmpid(Eid);

		Example<Allocation> example = Example.of(emptyAllocationWithEid);

		List<Allocation> all = employeeRepository.findAll(example);

		return all;
	}

}
