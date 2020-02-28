package com.ishan.allocater.service;

import java.util.List;

import com.ishan.allocater.model.Allocation;

public interface EmployeeService {
	public List<Allocation> getAllocationList();

	public Allocation save(Allocation allocation);

	public List<Allocation> findAllocationsByEid(Integer id);
}
