package com.example.demo;

import org.springframework.data.repository.CrudRepository;

/**
 * 學生資料的資料存取層（DAO）
 * 不用自己寫實作，Spring Data 會自動幫你提供基本的 CRUD
 * 這裡主鍵是 Integer，所以第二個泛型是 Integer
 */
public interface StudentRepository extends CrudRepository<Student,Integer> {
    // save, findById, findAll, deleteById 等方法都可以直接用
}
