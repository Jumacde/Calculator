package com.example.calculator.impl;

import com.example.calculator.CalcNumber;
import com.example.calculator.CalcOperator;

public class CalcNumber_impl implements CalcNumber {
    private String currentNum; // input number. String: to input a number after input another one. ex: 11, 23
    private double storedNum; // already inputted number.
    private boolean isInput; // input state. true => allow input, false => reject input

    public CalcNumber_impl() {
        this.currentNum = "0";
        this.storedNum = 0;
        this.isInput = false;
    }

    // getter
    @Override
    public String getCurrentNum() {
        return currentNum;
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
    public void setCurrentNum(String currentNum) {
        this.currentNum = currentNum;
        this.isInput = true;
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
    public void callDoCalc(CalcOperator calcOperator) {
        doCalc(calcOperator);
    }

    private void doCalc(CalcOperator calcOperator) {
        String operator = calcOperator.getOperator();
        double cNum = Double.parseDouble(currentNum); // String currentNumber convert to double.
        double calcResult;
        setIsInput(true);
        while(isInput) {
            if (operator.equals("+")) {
                calcResult = storedNum + cNum;
            } else if (operator.equals("-")) {
                calcResult = storedNum - cNum;
            } else if (operator.equals("*")) {
                calcResult = storedNum * cNum;
            } else if (operator.equals("/")) {
                calcResult = storedNum / cNum;
            } else {
                return;
            }
        }

    }

}
