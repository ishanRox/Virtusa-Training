package com.ishan.app.hystrix;

import com.ishan.app.model.Allocation;
import com.ishan.app.model.Employee;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.cloud.netflix.hystrix.HystrixCommands;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AllocationCommand extends HystrixCommand<Allocation[]> {
	Employee employee;
	HttpHeaders httpHeaders;
	RestTemplate restTemplate;

	public AllocationCommand(Employee employee, HttpHeaders httpHeaders, RestTemplate restTemplate) {
		super(HystrixCommandGroupKey.Factory.asKey("default"));
		this.employee = employee;
		this.httpHeaders = httpHeaders;
		this.restTemplate = restTemplate;
	}

	@Override
	protected Allocation[] run() throws Exception {

		HttpEntity<String> httpEntity = new HttpEntity<>("", httpHeaders);

		ResponseEntity<Allocation[]> responseEntity = restTemplate.exchange(
				"http://allocater/services/getbyid/" + employee.getId(), HttpMethod.GET, httpEntity,
				Allocation[].class);

		return responseEntity.getBody();
	}

	@Override
	protected Allocation[] getFallback() {
// This is because we must return Allocation []
// So we use one object array Trick to make method belive we return an array
//		Allocation[] allocation = new Allocation[1];
//		allocation[1].setProjectName("Server Down");
//		allocation[1].setStartDate("2222");
//		return allocation;
		Allocation[] allocations= new Allocation[5];
		Allocation allocation= new Allocation();
		allocation.setEmpid(1);
		allocation.setProjectName("sdfasfafafaf");
		allocations[0]=allocation;
		return  allocations;
	}
}
