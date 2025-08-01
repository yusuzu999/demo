package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 提供學生資料的 REST API
 */

// 告訴 Spring 這個 class 裡的方法都是 HTTP API，用 JSON 進出
@RestController
public class StudentController {

    // 自動把 StudentRepository 拿來用（資料存取層）
    @Autowired
    private StudentRepository studentRepository;

    /**
     * 處理 POST /students 的請求：把前端傳來的 student 存進資料庫
     * 範例請求 body (JSON):
     * {
     *   "name": "小明"
     * }
     */
    @PostMapping("/students")
    public String insert(@RequestBody Student student) {

        // 呼叫 repository 存資料，沒有 id 就新增
        studentRepository.save(student);

        // 回傳簡單文字，表示這支 insert 已經執行
        return "執行資料的insert 操作";
    }
}
