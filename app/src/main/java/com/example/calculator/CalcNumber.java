package com.example.calculator;

public interface CalcNumber {
    String getInputNum();
    double getStoredNum();
    void setInputNum();
    void setStoredNum();

    void callDoCalc(String operator); // wrap method
}
