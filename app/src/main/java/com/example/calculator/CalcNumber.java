package com.example.calculator;

public interface CalcNumber {
    String getInputNum();
    double getStoredNum();
    void setInputNum();
    void setStoredNum();

    // wrap methods
    void callDoCalc(String operator);
    void callNumberButton();
}
