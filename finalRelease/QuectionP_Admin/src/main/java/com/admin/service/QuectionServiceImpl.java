package com.admin.service;

import java.util.List;

import com.admin.model.Quection;
import com.admin.repository.QRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
