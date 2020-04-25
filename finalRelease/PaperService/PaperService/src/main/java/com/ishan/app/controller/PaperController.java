package com.ishan.app.controller;

import com.ishan.app.model.Quection;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ishan.app.service.QuectionService;

//Declare this class as Rest controller class
@RestController
@RequestMapping("services")
@CrossOrigin
public class PaperController {

	// Service bean has been made so autowire it to out reference
	@Autowired
	QuectionService quectionService;

	
	//CAll from employee server to allocation server and get data and parse it
	@RequestMapping("/getpaper")
	public Quection[] getAllemployees(@RequestParam String subject,@RequestParam String title) {
		Quection[] quections = quectionService.fetchQuections(subject,title);
		System.out.println(quections);
		return quections;
	}


}
