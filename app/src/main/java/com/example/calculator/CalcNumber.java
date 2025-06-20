package com.example.calculator;

public interface CalcNumber {
    String getInputNum();
    double getStoredNum();
    boolean getIsInput();
    void setInputNum(String inputNum);
    void setStoredNum(double storedNum);
    void setIsInput(boolean isInput);

    // wrap methods
    void callDoCalc(String operator);
    void callNumberButton(String num);
}
