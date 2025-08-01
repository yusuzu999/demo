package com.example.demo;

/**
 * 簡單的計算器，現在只有加法功能。
 */
public class Calculator {

    /**
     * 回傳兩個整數的和。
     *
     * @param x 第一個加數
     * @param y 第二個加數
     * @return x + y
     */
    public int add(int x, int y){
        return x + y;
    }

    public int divide(int x, int y){
        return x/y;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = calculator.add(1, 2);
        System.out.println("結果為:"+result);
    }
}
