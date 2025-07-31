package com.example.demo.dao;

import com.example.demo.model.Students;

import java.util.List;

public interface StudentDao
{
    void insert(Students student);
    void batchInsert(List<Students> studentList);
    void deleteById(Integer studentId);
    Students getById(Integer studentId);
}
