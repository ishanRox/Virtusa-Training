package com.ishan.app.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(mappedBy = "projects")
	List<Employee> employees;
}
