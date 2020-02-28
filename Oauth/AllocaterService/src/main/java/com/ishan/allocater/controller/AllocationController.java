package com.ishan.allocater.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ishan.allocater.model.Allocation;
import com.ishan.allocater.service.EmployeeService;

@RestController
@RequestMapping("/services")
public class AllocationController {
	@Autowired
	EmployeeService employeeService;

    //Test to get json value
	@RequestMapping("/test")
	public Allocation getTest() {
		Allocation allocation = new Allocation();
		allocation.setEmpid(1);
		allocation.setEndDate("4");
		allocation.setStartDate("1");
		allocation.setProjectName("Ishan Vimukthi");

		return allocation;
	}

	// Get allocations list
	@RequestMapping("/allocations")
	public List<Allocation> getAllocations() {
		return employeeService.getAllocationList();
	}

	// insert into allocatios List
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public Allocation getAllocation(@RequestBody Allocation allocation) {
		Allocation allocation1 = employeeService.save(allocation);
		return allocation1;
	}

	@RequestMapping("/getbyid/{id}")
	public List<Allocation> allocations(@PathVariable Integer id) {
		List<Allocation> allocation = employeeService.findAllocationsByEid(id);
		return allocation;
	}

}
