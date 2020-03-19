package com.ishan.app.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ishan.app.model.Employee;

@Entity
public class Telephone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	int no;

	//JsonIgnore to stop recurtion
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	Employee employee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
