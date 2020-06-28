package com.practise.jpa.controller;

import com.practise.jpa.model.Student;
import com.practise.jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class MainController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String greeting() {
        return "hello springboot";
    }

    @PostMapping(value = "/student")
    public Student save(@RequestBody Student student) {

        return studentService.save(student);
    }

    //http://localhost:8080/student?firstName=ishan&lastName=vihanga

    @GetMapping(value = "/student")
    public ResponseEntity<Student> student(@RequestParam Integer id) {

        Student student = studentService.findById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(student);
        }

    }
}
