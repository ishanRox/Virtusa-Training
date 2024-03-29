package com.ishan.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ishan.app.model.Employee;
import com.ishan.app.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee save(Employee e) {
		Employee employee = employeeRepository.save(e);
		return employee;
	}
}
