package com.javainuse.service;

import java.util.List;
import java.util.Optional;

import com.javainuse.model.Quection;
import com.javainuse.repository.QRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;


@Service
public class QuectionServiceImpl implements QuectionService {


	@Autowired
    QRepository employeeRepository;

	@Override
	public Quection save(Quection e) {
      Quection employee = employeeRepository.save(e);
		return employee;
	}

	@Override
	public Quection findById(int id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).get();
	}

	@Override
	public String deleteQ(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
		return (id != 0) ? "Employee deleted with id:-" + id : "NO users";
	}

  @Override
  public List<Quection> fethAllQuections() {
    return employeeRepository.findAll();
  }


}
