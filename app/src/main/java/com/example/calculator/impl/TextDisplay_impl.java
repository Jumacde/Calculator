package com.example.calculator.impl;

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

    }

}
