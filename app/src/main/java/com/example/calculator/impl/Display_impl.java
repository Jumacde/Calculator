package com.example.calculator.impl;

import com.example.calculator.Display;

public class Display_impl implements Display {
    private String textDisplay;

    public Display_impl() {

    }

    @Override
    public String getTextDisplay() {
        return textDisplay;
    }

    @Override
    public void setTextDisplay(String textDisplay) {
        this.textDisplay = textDisplay;
    }

    @Override
    public void callUpdateDisplay() {
        updateDisplay();
    }

    private void updateDisplay() {

    }

}
