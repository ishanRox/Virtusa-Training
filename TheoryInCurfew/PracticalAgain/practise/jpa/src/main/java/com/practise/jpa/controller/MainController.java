package com.practise.jpa.controller;

import com.practise.jpa.model.Student;
import com.practise.jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String greeting() {
        return "hello springboot";
    }
@RequestMapping(value = "/student",method = RequestMethod.POST)
    public Student save(@RequestBody Student student) {

        return  studentService.save(student);
    }

}
