package com.ishan.app.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import javax.transaction.TransactionalException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ishan.app.model.Address;
import com.ishan.app.model.Employee;
import com.ishan.app.model.Project;
import com.ishan.app.model.Telephone;
import com.ishan.app.repository.EmployeeRepository;
import com.ishan.app.service.EmployeeService;

//Declare this class as Rest controller class
@RestController
@RequestMapping("services")
public class EmployeeController {

	// Service bean has been made so autowire it to out reference
	@Autowired
	EmployeeService employeeService;

	
	//CAll from employee server to allocation server and get data and parse it
	@RequestMapping("/allocation/{id}")
	public Employee getAllemployees(@PathVariable int id) {
		Employee employee = employeeService.fethAllEmployees(id);
		return employee;
	}

	// get the sample json from test and make a post request to
	// http://localhost:8080/service/employees to insert to DB
	@RequestMapping("test")
	public Employee test() {
		Employee employee = new Employee();
		employee.setId(10);
		employee.setName("ishan");
		employee.setMarks("99");

		// Adress info
		Address adress = new Address();
		adress.setCity("Ragama");
		employee.setAddress(adress);

		Telephone telephone = new Telephone();
		telephone.setNo(11989);

		Telephone telephone1 = new Telephone();
		telephone1.setNo(115258989);

		List<Telephone> list = new ArrayList<>();
		list.add(telephone);
		list.add(telephone1);

		// add TP list to the employee
		employee.setTelephones(list);

		// get the telephones without employee and set employee
		employee.getTelephones().stream().forEach(t -> {
			t.setEmployee(employee);
		});
		// Adress info over

		// Project info
		Project project = new Project();
		project.setName("project1");

		Project project1 = new Project();
		project1.setName("project2");

		List<Project> projectList = new ArrayList<Project>();
		projectList.add(project);
		projectList.add(project1);
		// Project info ends

		employee.setProjects(projectList);

		return employee;
	}

	// findThe selected Employee and return so this is done by JpaRepository find method
	@RequestMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable int id) {
		if (id == 0) {
			Employee employee = new Employee();
			employee.setId(10);
			employee.setName("ishan");
			return employee;
		} else
			return employeeService.findById(id);

	}

	// Delete And check if the cascading works
	// both employee and adress must be deleted
	@RequestMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return employeeService.deleteEmployee(id);
	}

	// @Transactional=say to rollback apon a exception
	@Transactional(rollbackOn = TransactionalException.class)
	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public Employee getEmployees(@RequestBody Employee e) {

		// get the telephone List from the Employee and set telephone no to employee
		e.getTelephones().stream().forEach(t -> {
			t.setEmployee(e);
		});

		Employee eee = employeeService.save(e);
		return eee;
	}
}
