package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    public void test() {
        // 建立 Calculator 實例
        Calculator calculator = new Calculator();

        // 呼叫加法方法，取得實際結果
        int result = calculator.add(1,2);

        // 驗證實際結果是否與預期 3 相符
        assertEquals(3,result);
    }

}