package com.example.demo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Disabled
    @Test
    public void add() {
        // 建立 Calculator 實例
        Calculator calculator = new Calculator();

        // 呼叫加法方法，取得實際結果
        int result = calculator.add(1,2);

        assertNotNull(result);

        // 驗證實際結果是否與預期 3 相符
        assertEquals(3,result,"加法有問題");

        assertTrue(result > 1);

    }

    @DisplayName("測試除法問題")
    @Test
    public void divide(){

        // 準備：建立 Calculator
        Calculator calculator = new Calculator();

        // 驗證：除以 0 時會丟出 ArithmeticException
        assertThrows(ArithmeticException.class,()->{
            calculator.divide(1,0);
        });
    }

}