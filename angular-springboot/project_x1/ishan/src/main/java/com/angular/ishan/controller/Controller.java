package com.angular.ishan.controller;

import com.angular.ishan.model.Employee;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//handle cors for our angular
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Controller {

  private List<Employee> employees = createEmpList();

  //get a List of employees just to show in rest endpoint to angular
  private static List<Employee> createEmpList() {

    List<Employee> employees = new ArrayList<>();

    Employee employee = new Employee();
    employee.setName("emp1");
    employee.setDesignation("Architec");
    employee.setEmpId("1");
    employee.setSalary(3000);

    Employee employee1 = new Employee();
    employee1.setName("emp1");
    employee1.setDesignation("Architec");
    employee1.setEmpId("1");
    employee1.setSalary(3000);

    employees.add(employee);
    employees.add(employee1);

    return employees;
  }

  @RequestMapping(value = "emp", method = RequestMethod.GET, produces = "application/json")
  public List<Employee> firstPage() {
    return employees;
  }
}
