package com.ishan.app.controller;

import com.ishan.app.model.Quection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ishan.app.service.QuectionService;

//Declare this class as Rest controller class
@RestController
@RequestMapping("services")
public class EmployeeController {

	// Service bean has been made so autowire it to out reference
	@Autowired
	QuectionService quectionService;

	
	//CAll from employee server to allocation server and get data and parse it
	@RequestMapping("/allocation")
	public Quection[] getAllemployees(@RequestParam String subject,@RequestParam String title) {
		Quection[] quections = quectionService.fetchQuections(subject,title);
		return quections;
	}


}
