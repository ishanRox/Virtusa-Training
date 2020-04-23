package com.ishan.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ishan.app.hystrix.PaperCommand;
import com.ishan.app.model.Quection;

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
		PaperCommand allocationCommand = new PaperCommand(subject,title, httpHeaders, restTemplate);

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


		}

}
