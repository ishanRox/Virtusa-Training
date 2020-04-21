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
		System.out.println(subject+" subject and title "+title);

		ResponseEntity<Quection[]> responseEntity = restTemplate.exchange(
							"http://allocater/api/getpaper/?subjectid="+subject+"&title="+title, HttpMethod.GET, httpEntity,
							Quection[].class);

		System.out.println("response entity");
		System.out.println(responseEntity.getBody());

		return responseEntity.getBody();
	}

	@Override
	protected Quection[] getFallback() {
		Quection[] quections = new Quection[5];
		Quection quection = new Quection();
		quection.setId(1);
		quection.setText("sdfasfafafaf");
		quections[0]= quection;
		return quections;
	}
}
