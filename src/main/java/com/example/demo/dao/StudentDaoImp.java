package com.example.demo.dao;

import com.example.demo.mapper.StudentRowMapper;
import com.example.demo.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StudentDaoImp implements StudentDao{

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Students getById(Integer studentId) {
        String sql="select id,name from student where id=:studentId";

        Map<String,Object> map = new HashMap<>();
        map.put("studentId",studentId);

        List<Students> list = namedParameterJdbcTemplate.query(sql,map,new  StudentRowMapper());

        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }


    @Override
    public void insert(Students student) {
        String sql="INSERT INTO student(name) VALUES(:studentName)";

        Map<String,Object> map = new HashMap<>();
        map.put("studentName",student.getName());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource(map),keyHolder);

        int id=keyHolder.getKey().intValue();
        System.out.println("mysql 自動生成的id為:" + id);
    }

    @Override
    public void batchInsert(List<Students> studentList) {
        String sql="INSERT INTO student(name) VALUES(:studentName)";

        MapSqlParameterSource[] mapSqlParameterSource = new MapSqlParameterSource[studentList.size()];

        for (int i=0 ; i<studentList.size();i++) {
            Students student=studentList.get(i);
            mapSqlParameterSource[i]=new MapSqlParameterSource();
            mapSqlParameterSource[i].addValue("studentName",student.getName());
        }
        namedParameterJdbcTemplate.batchUpdate(sql,mapSqlParameterSource);
    }

    @Override
    public void deleteById(Integer studentId) {
        String sql="DELETE FROM student where id=:studentId";

        Map<String,Object> map = new HashMap<>();
        map.put("studentId",studentId);

        namedParameterJdbcTemplate.update(sql,map);
    }
}
