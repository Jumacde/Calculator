package com.example.calculator;

public interface Display {
    // getter
    String getTextDisplay();

    // setter
    void setTextDisplay(String textDisplay);
    void clearDisplay(); // method: clear display
    // wrap method
    void callUpdateDisplay();
}
