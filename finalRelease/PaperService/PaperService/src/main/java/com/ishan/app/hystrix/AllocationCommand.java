package com.ishan.app.hystrix;

import com.ishan.app.model.Quection;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AllocationCommand extends HystrixCommand<Quection[]> {
	String subject;
	String title;
	HttpHeaders httpHeaders;
	RestTemplate restTemplate;

	public AllocationCommand(String subject,String title, HttpHeaders httpHeaders, RestTemplate restTemplate) {
		super(HystrixCommandGroupKey.Factory.asKey("default"));
		this.subject=subject;
		this.title=title;
		this.httpHeaders = httpHeaders;
		this.restTemplate = restTemplate;
	}

	@Override
	protected Quection[] run() throws Exception {
		System.out.println("inside run");
		HttpEntity<String> httpEntity = new HttpEntity<>("", httpHeaders);
		System.out.println(subject+" "+title);

		ResponseEntity<Quection[]> responseEntity = restTemplate.exchange(
							"http://allocater/api/getpaper/?subjectid="+subject+"&title="+title, HttpMethod.GET, httpEntity,
							Quection[].class);

		System.out.println("response entity");
		System.out.println(responseEntity.getBody()[0].getText()+"response ");
		return responseEntity.getBody();
	}

	@Override
	protected Quection[] getFallback() {
// This is because we must return Allocation []
// So we use one object array Trick to make method belive we return an array
//		Allocation[] allocation = new Allocation[1];
//		allocation[1].setProjectName("Server Down");
//		allocation[1].setStartDate("2222");
//		return allocation;
		Quection[] quections = new Quection[5];
		Quection quection = new Quection();
		quection.setId(1);
		quection.setText("sdfasfafafaf");
		quections[0]= quection;
		return quections;
	}
}
