package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 提供學生資料的 REST API
 */

// 告訴 Spring 這個 class 裡的方法都是 HTTP API，用 JSON 進出
@RestController
public class StudentController {

    // 自動把 StudentRepository 拿來用（資料存取層）
    @Autowired
    private StudentRepository studentRepository;


    @PutMapping("/students/{studentId}")
    public String update(@PathVariable Integer studentId,
                         @RequestBody Student student) {

        // 從網址路徑抓 studentId，例如 PUT /students/5 會把 5 拿來當 ID
        // 去資料庫找這個 ID 的學生，找不到就回 null
        Student s = studentRepository.findById(studentId).orElse(null);

        if (s != null) {
            // 找到的話，把資料庫裡的那個學生的名字改成前端送來的名字
            s.setName(student.getName());

            // 呼叫 repository 存資料，因為 s 本來有 ID，所以是更新（不是新增）
            studentRepository.save(s);
        } else {
            return "Update失敗 數據不存在";
        }

        // 回傳簡單文字，表示這支 insert 已經執行
        return "執行資料的update 操作";
    }

    // 從網址拿到 studentId，例如 GET /students/5 裡的 5
    @GetMapping("/students/{studentId}")
    public Student read(@PathVariable Integer  studentId) {

        // 去資料庫找這個 ID 的學生，找不到就回 null
        Student student = studentRepository.findById(studentId).orElse(null);
        /**
         * findById(studentId) 會去資料庫找那個 ID 的學生，
         *    結果包在一個 Optional 裡面（表示「可能有、也可能沒有」的東西）。
         * .orElse(null) 的意思是：「如果有找到，就拿那個 Student；如果沒找到，就回傳 null。」
         * 所以這整段最後的結果是：
         * 找到的話拿到 Student 物件，找不到的話變成 null。
         */
        // 回傳找到的學生（找不到時是 null）
        return student;
    }
}
