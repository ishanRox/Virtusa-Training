package com.javainuse.controller;

import com.javainuse.model.Employee;
import com.javainuse.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//handle cors for our angular
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/emp"})
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
    employee1.setEmpId("2");
    employee1.setSalary(3000);

    Employee employee2 = new Employee();
    employee2.setName("emp1");
    employee2.setDesignation("Architec");
    employee2.setEmpId("3");
    employee2.setSalary(3000);

    employees.add(employee);
    employees.add(employee1);
    employees.add(employee2);

    return employees;
  }
//no need  any more
//  @GetMapping(produces = "application/json")
//  @RequestMapping({ "/validate" })
//  public User validateLogin() {
//    return new User("User successfully authenticated");
//  }


  @RequestMapping(value = "emp", method = RequestMethod.GET, produces = "application/json")
  public List<Employee> firstPage() {
    return employees;
  }

  @DeleteMapping(path = {"/{id}"})
  public Employee delete(@PathVariable("id") int id) {
    System.out.println(id);

    Employee deletedEmp = employees.stream().filter(e -> e.getEmpId().equals(id + "")).findFirst().get();

    employees = employees.stream()
            .filter(e -> !e.getEmpId().equals(id + ""))
            .collect(Collectors.toList());

    return deletedEmp;
  }

  @PostMapping
  public Employee create(@RequestBody Employee user) {
    employees.add(user);
    System.out.println(employees);
    return user;
  }
}
