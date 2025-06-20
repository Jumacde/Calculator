package com.example.calculator;

public interface CalcNumber {
    String getCurrentNum();
    double getStoredNum();
    boolean getIsInput();
    void setCurrentNum(String currentNum);
    void setStoredNum(double storedNum);
    void setIsInput(boolean isInput);

    // wrap methods
    void callDoCalc(CalcOperator calcOperator);
}
