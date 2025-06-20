package com.example.calculator;

public interface Display {
    // getter
    String getTextDisplay();

    // setter
    void setTextDisplay(String textDisplay);

    // wrap method
    void callUpdateDisplay();
}
