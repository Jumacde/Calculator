package com.example.calculator.impl;

import com.example.calculator.CalcNumber;

public class CalcNumber_impl implements CalcNumber {
    private String inputNum; // input number. String: to input a number after input another one. ex: 11, 23
    private double storedNum; // already inputted number.
    private boolean isInput; // input state. true => allow input, false => reject input

    public CalcNumber_impl() {
        this.inputNum = "0";
        this.storedNum = 0;
        this.isInput = false;
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

    @Override
    public boolean getIsInput() {
        return isInput;
    }

    // setter
    @Override
    public void setInputNum(String inputNum) {
        this.inputNum = inputNum;
    }

    @Override
    public void setStoredNum(double storedNum) {
        this.storedNum = storedNum;
    }

    @Override
    public void setIsInput(boolean isInput) {
        this.isInput = isInput;
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

    /**
     * wrap method
     * **/
    @Override
    public void callNumberButton() {
        numberButton();
    }

    private void doCalc(String operator) {

    }

    private void numberButton() {

    }

}
