package com.angular.ishan.service;


import com.angular.ishan.model.Subject;
import com.angular.ishan.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
  @Autowired
  SubjectRepository subjectRepository;

  @Override
  public Subject saveSubject(Subject subject){
    subjectRepository.save(subject);
    return subject;
  }

  @Override
  public Subject findById(int id) {
    // TODO Auto-generated method stub

    return subjectRepository.findById(id).get();
  }

  @Override
  public void deleteSubject(int id) {
    Subject subject=findById(id);
    subjectRepository.delete(subject);

  }

  @Override
  public List<Subject> getAll() {
    return subjectRepository.findAll();
  }

}
//  @Autowired
//  EmployeeRepository employeeRepository;
//
//  @Override
//  public Employee save(Employee e) {
//    Employee employee = employeeRepository.save(e);
//    return employee;
//  }
//
//  @Override
//  public Employee findById(int id) {
//    // TODO Auto-generated method stub
//    return employeeRepository.findById(id).get();
//  }
//
//  @Override
//  public String deleteEmployee(int id) {
//    // TODO Auto-generated method stub
//    employeeRepository.deleteById(id);
//    return (id != 0) ? "Employee deleted with id:-" + id : "NO users";
//  }
//
//  @Override
//  public Employee fethAllEmployees(int id) {
//    Optional<Employee> employee = employeeRepository.findById(id);
//    System.out.println("Sending through emp 1");
//    if (employee.isPresent()) {
//      System.out.println(employee.get().getName());
//      HttpEntity<String> stringHttpEntity = new HttpEntity<>("", new HttpHeaders());
//
//      Employee employee1 = employee.get();
//
//      ResponseEntity<Allocation[]> responseEntity = restTemplate.exchange("http://allocater/services/getbyid/" + id,
//              HttpMethod.GET, stringHttpEntity, Allocation[].class);
//
//      employee1.setAllocations(responseEntity.getBody());
//
//      return employee1;
//    } else
//      return null;
//  }