package com.example.calculator;

public interface CalcNumber {
    String getCurrentNum();
    double getStoredNum();
    boolean getIsInput();
    double getCalcResult();

    void setCurrentNum(String currentNum);
    void setStoredNum(double storedNum);
    void setIsInput(boolean isInput);
    void setCalcResult(double calcResult);

    // wrap methods
    void callDoCalc(CalcOperator calcOperator);
}
