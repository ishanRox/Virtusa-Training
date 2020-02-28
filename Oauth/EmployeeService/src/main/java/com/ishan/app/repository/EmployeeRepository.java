package com.ishan.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ishan.app.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
