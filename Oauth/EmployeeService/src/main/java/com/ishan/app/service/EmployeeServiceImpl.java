package com.ishan.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.ishan.app.hystrix.AllocationCommand;
import com.ishan.app.model.Allocation;
import com.ishan.app.model.Employee;
import com.ishan.app.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	// Rest template
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;
	// Rest template

	@Bean
	@LoadBalanced
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee save(Employee e) {
		Employee employee = employeeRepository.save(e);
		return employee;
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).get();
	}

	@Override
	public String deleteEmployee(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
		return (id != 0) ? "Employee deleted with id:-" + id : "NO users";
	}

	HttpHeaders httpHeaders = new HttpHeaders();
	HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);

	// Histrix code for fallBack
	public Allocation[] fetchAllocation(Employee employee) {
		AllocationCommand allocationCommand = new AllocationCommand(employee, httpHeaders, restTemplate);
		return allocationCommand.execute();
	}

	@Override
	public Employee fethAllEmployees(int id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		System.out.println("Sending through emp 1");
		if (employee.isPresent()) {

			System.out.println(employee.get().getName());
			Employee employee1 = employee.get();
// We comment out all the code for sending normal request
// Now we are sending it through our fetchAllocation method wich uses
// AllocationCommand
// So Even server is down we assign default object for it through fallBack Method
//			ResponseEntity<Allocation[]> responseEntity = restTemplate.exchange(
//					"http://allocater/services/getbyid/" + id, HttpMethod.GET, httpEntity, Allocation[].class);
//			employee1.setAllocations(responseEntity.getBody());

			employee1.setAllocations(fetchAllocation(employee1));

			return employee1;
		} else
			return null;
	}

}
