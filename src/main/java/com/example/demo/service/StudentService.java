package com.example.demo.service;

import com.example.demo.model.Students;
import java.util.List;

public interface StudentService {
    void insert(Students student);
    void batchInsert(List<Students> studentList);
    void deleteById(Integer studentId);
    Students getById(Integer studentId);
}
