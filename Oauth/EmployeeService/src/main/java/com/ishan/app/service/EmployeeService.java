package com.ishan.app.service;

import com.ishan.app.model.Employee;

public interface EmployeeService {

	Employee save(Employee e);

	Employee findById(int id);

	String deleteEmployee(int id);

	Employee fethAllEmployees(int id);
}
