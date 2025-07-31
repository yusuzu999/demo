package com.example.demo.controller;

import com.example.demo.model.Students;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController
{
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private StudentService studentService;

    //
    // insert 1 row
    //
    @PostMapping("/students")
    public String insert(@RequestBody Students student ) {
        studentService.insert(student);
        return "insert 1 row";
    }

    @PostMapping("/students/batch")
    public String insertList(@RequestBody List<Students> studentList ) {
          studentService.batchInsert(studentList);
          return "batch insert";
    }

    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Integer studentId ) {
           studentService.deleteById(studentId);
           return "delete 1";
    }

    @GetMapping("/students/{studentId}")
    public Students select(@PathVariable Integer studentId) {
        return studentService.getById(studentId);
    }


}