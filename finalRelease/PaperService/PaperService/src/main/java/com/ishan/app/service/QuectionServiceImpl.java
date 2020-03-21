package com.ishan.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.ishan.app.hystrix.AllocationCommand;
import com.ishan.app.model.Quection;

import java.util.Arrays;

@Service
public class QuectionServiceImpl implements QuectionService {

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




	HttpHeaders httpHeaders = new HttpHeaders();
	HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);

	// Histrix code for fallBack
	public Quection[] fetchAllocation(String subject,String title) {
		System.out.println("in fetch allocaation");
		AllocationCommand allocationCommand = new AllocationCommand(subject,title, httpHeaders, restTemplate);

		return allocationCommand.execute();
	}

	@Override
	public Quection[] fetchQuections( String subject, String title) {

		Quection[] javaBasics = fetchAllocation(subject, title);

		//when server is not down but no Quections
		if (javaBasics == null) {
		//get data from git

			Quection quection= new Quection();
			quection.setText("from github");

			Quection quection1= new Quection();
			quection.setText("sfsafadfadfaf");

			Quection quection2= new Quection();
			quection.setText("sfsafadfadfaf");

			Quection[] quections=new Quection[5];
			quections[0]=quection;
			quections[1]=quection1;
			quections[2]=quection2;

			return quections;
		}


		return javaBasics;
//		Optional<List<Quection>> employee = employeeRepository.findById(id);
//		System.out.println("Sending through emp 1");
//		if (employee.isPresent()) {
//
//			System.out.println(employee.get().getName());
//			Employee employee1 = employee.get();
//// We comment out all the code for sending normal request
//// Now we are sending it through our fetchAllocation method wich uses
//// AllocationCommand
//// So Even server is down we assign default object for it through fallBack Method
////			ResponseEntity<Allocation[]> responseEntity = restTemplate.exchange(
////					"http://allocater/services/getbyid/" + id, HttpMethod.GET, httpEntity, Allocation[].class);
////			employee1.setAllocations(responseEntity.getBody());
//
//			employee1.setQuections(fetchAllocation(employee1));
//
//			return employee1;
//		} else {
//		Employee employee1= new Employee();
//		employee1.setQuections(fetchAllocation(employee1));
//		employee1.setName("sdfdasf");
//			return employee1;


		}

}
