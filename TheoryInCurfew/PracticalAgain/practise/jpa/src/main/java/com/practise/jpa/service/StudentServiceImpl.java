package com.practise.jpa.service;

import com.practise.jpa.model.Student;
import com.practise.jpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findById(int id) {
        Optional<Student> student = studentRepository.findById(id);

        if (student.isPresent()) {
            return student.get();
        } else {
            return null;
        }
    }

}
