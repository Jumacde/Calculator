package com.example.calculator.impl;

import com.example.calculator.CalcNumber;
import com.example.calculator.CalcOperator;

/**
* class: control the number and calculate rule.
**/
public class CalcNumber_impl implements CalcNumber {
    private String currentNum; // input number. String: to input a number after input another one. ex: 11, 23
    private double storedNum; // already inputted number.
    private boolean isInput; // input state. true => allow input, false => reject input
    private double calcResult; // calculate result.

    public CalcNumber_impl() {
        this.currentNum = "0";
        this.storedNum = 0;
        this.isInput = false;
        this.calcResult = 0;
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

    @Override
    public double getCalcResult() {
        return calcResult;
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

    @Override
    public void setCalcResult(double calcResult) {
        this.calcResult = calcResult;
    }

    /**
     * wrap method
     * @ Param: CalcOperator calcOperator
     * - call the interface class calcOperator.
     * **/
    @Override
    public void callDoCalc(CalcOperator calcOperator) {
        doCalc(calcOperator);
    }

    /**
     * method: define the calculate-Rule and -result.
     * @ Param: CalcOperator calcOperator
     * - call the interface class calcOperator to use  String operator = calcOperator.getOperator()
     * */
    private void doCalc(CalcOperator calcOperator) {
        String operator = calcOperator.getOperator();
        double cNum = Double.parseDouble(currentNum); // String currentNumber convert to double.

        setIsInput(true);
        if (operator.isEmpty()) {
            return;
        } else if (operator.equals("+")) {
            calcResult = storedNum + cNum;
        } else if (operator.equals("-")) {
            calcResult = storedNum - cNum;
        } else if (operator.equals("*")) {
            calcResult = storedNum * cNum;
        } else if (operator.equals("/")) {
            if (cNum == 0) {
                calcResult = Double.POSITIVE_INFINITY;
            } else {
                calcResult = storedNum / cNum;
            }
        }
    }
}
