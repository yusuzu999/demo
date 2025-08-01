package com.example.demo;

import jakarta.persistence.*;

/**
 * 這個 class 代表一筆學生資料，
 * 會對應到資料庫裡的 student 這張表
 */
@Entity
@Table(name="student")
public class Student {

    // 這是學生的 ID，資料庫會自己給（一筆資料的唯一識別）
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    Integer id;

    // 這是學生的名字
    @Column(name="name")
    String name;

    // 下面是拿跟設這兩個欄位用的（外面要用這些去讀/寫）
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
