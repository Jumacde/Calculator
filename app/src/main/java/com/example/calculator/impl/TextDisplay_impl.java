package com.example.calculator.impl;

import android.annotation.SuppressLint;

import com.example.calculator.CalcNumber;
import com.example.calculator.CalcOperator;
import com.example.calculator.TextDisplay;

/**
 * class: control the showing displays.
 * **/
public class TextDisplay_impl implements TextDisplay {
    private String textDisplay;
    private final CalcNumber calcNumber;
    private final CalcOperator calcOperator;

    public TextDisplay_impl(CalcNumber calcNumber, CalcOperator calcOperator) {
        this.calcNumber = calcNumber;
        this.calcOperator = calcOperator;
        clearDisplay(); // initialize display.
    }

    @Override
    public String getTextDisplay() {
        return textDisplay;
    }

    @Override
    public void setTextDisplay(String textDisplay) {
        this.textDisplay = textDisplay;
    }

    // method: clear display
    @Override
    public void clearDisplay() {
        this.textDisplay = "0";
        this.calcNumber.setCurrentNum("0");
        this.calcNumber.setStoredNum(0);
        this.calcNumber.setIsInput(false);
        this.calcNumber.setCalcResult(0);
        this.calcOperator.setOperator("");
    }

    /**
     * wrap method: to use updateDisplay method.
     * **/
    @Override
    public void callUpdateDisplay() {
        updateDisplay();
    }

    // method: update display.
    private void updateDisplay() {
        String currentNum = calcNumber.getCurrentNum();
        double cNum = Double.parseDouble(currentNum);
        double storedNum = calcNumber.getStoredNum();
        double calcResult = calcNumber.getCalcResult();
        String operator = calcOperator.getOperator();
        boolean isInput = calcNumber.getIsInput();


        if (textDisplay.equals("=")) {
            textDisplay = formatNumber(calcResult);
        } else if (!operator.isEmpty() && isInput) {
            textDisplay = formatNumber(storedNum) + operator + formatNumber(cNum);
        } else if (!operator.isEmpty() && !isInput) {
            textDisplay = formatNumber(storedNum) + operator;
        } else {
            textDisplay = formatNumber(cNum);
        }
    }

    /**
     * - method: float number format to a integer
     * @ param: double num
     * - set each number(storedNumber)
     * **/
    @SuppressLint("DefaultLocale")
    private String formatNumber(double num) {
        if (num == (long) num) {
            return String.format("%d", (long) num);
        } else {
            return String.format("%s", num);
        }
    }

}
