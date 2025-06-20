package com.example.calculator.impl;

import com.example.calculator.CalcNumber;

public class CalcNumber_impl implements CalcNumber {
    private String inputNum; // input number. String: to input a number after input another one. ex: 11, 23
    private double storedNum; // already inputted number.

    public CalcNumber_impl() {
        this.inputNum = "0";
        this.storedNum = 0;
    }

    // getter
    @Override
    public String getInputNum() {
        return inputNum;
    }

    @Override
    public double getStoredNum() {
        return storedNum;
    }

    // setter
    @Override
    public void setInputNum() {
        this.inputNum = inputNum;
    }

    @Override
    public void setStoredNum() {
        this.storedNum = storedNum;
    }

    /**
     * wrap method
     * @ Param: String operator
     * - set a arithmetic operator(+, -, *, /)
     * **/
    @Override
    public void callDoCalc(String operator) {
        doCalc(operator);
    }

    private void doCalc(String operator) {

    }
}
