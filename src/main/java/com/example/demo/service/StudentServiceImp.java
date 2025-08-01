package com.example.demo.service;

import com.example.demo.model.Students;
import com.example.demo.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Students getById(Integer studentId) {
        return studentDao.getById(studentId);
    }

    @Override
    public void insert(Students student) {
         studentDao.insert(student);
    }

    @Override
    public void batchInsert(List<Students> studentList) {
        studentDao.batchInsert(studentList);
    }

    @Override
    public void deleteById(Integer studentId) {
        studentDao.deleteById(studentId);
    }
}
