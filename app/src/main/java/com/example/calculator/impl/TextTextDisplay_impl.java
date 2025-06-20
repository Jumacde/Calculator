package com.example.calculator.impl;

import com.example.calculator.CalcNumber;
import com.example.calculator.CalcOperator;
import com.example.calculator.TextDisplay;

public class TextTextDisplay_impl implements TextDisplay {
    private String textDisplay;
    private final CalcNumber calcNumber;
    private final CalcOperator calcOperator;

    public TextTextDisplay_impl(CalcNumber calcNumber, CalcOperator calcOperator) {
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
        this.calcNumber.setInputNum("0");
        this.calcNumber.setStoredNum(0);
        this.calcNumber.setIsInput(false);
        this.calcOperator.setOperator("");
    }

    @Override
    public void callUpdateDisplay() {
        updateDisplay();
    }

    private void updateDisplay() {

    }

}
