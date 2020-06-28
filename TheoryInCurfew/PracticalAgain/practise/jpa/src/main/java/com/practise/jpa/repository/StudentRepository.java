package com.practise.jpa.repository;

import com.practise.jpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
