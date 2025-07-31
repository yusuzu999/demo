package com.example.demo.mapper;

import com.example.demo.model.Students;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

// 這個類別的工作是：
// 當我們從資料庫撈出一行資料時，
// 要把這一行資料轉換成一個 Students 物件 (Java 物件)

public class StudentRowMapper implements RowMapper<Students> {
    // implements RowMapper<Students>
    // 表示這個類別要實作 RowMapper 這個介面
    // <Students>：代表我要把資料轉換成 Students 類別的物件

    @Override
    public Students mapRow(ResultSet resultSet, int rownum) throws SQLException {
        // mapRow() 是 RowMapper 規定要實作的方法
        // resultSet：這是一行從資料庫查詢出來的結果
        // rownum：代表這是第幾行資料 (0 開始計數)

        // 從資料庫這一行資料，拿出欄位 id 的值
        // "id" 必須跟資料表的欄位名稱對應
        Integer id = resultSet.getInt("id");

        // 從資料庫這一行資料，拿出欄位 name 的值
        String name = resultSet.getString("name");

        // 建立一個新的 Students 物件
        Students student = new Students();

        // 把從資料庫撈到的 id 塞到 student 的 id 欄位
        student.setId(id);

        // 把從資料庫撈到的 name 塞到 student 的 name 欄位
        student.setName(name);

        // 回傳這個完整的 Students 物件
        return student;
    }
}

