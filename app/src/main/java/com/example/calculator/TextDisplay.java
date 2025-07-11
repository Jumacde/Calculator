package com.example.calculator;

public interface TextDisplay {
    // getter
    String getTextDisplay();

    // setter
    void setTextDisplay(String textDisplay);
    void clearDisplay(); // method: clear display
    // wrap method
    String callUpdateDisplay();
    String callFormatNumber(double num);
}
