package com.practise.jpa.repository;

import com.practise.jpa.model.Student;
import org.springframework.data.repository.Repository;

public interface StudentRepository extends Repository<Student,Integer> {

    Student save(Student student);
}
