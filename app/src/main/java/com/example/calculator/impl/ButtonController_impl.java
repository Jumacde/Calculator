package com.example.calculator.impl;

import com.example.calculator.ButtonController;
import com.example.calculator.CalcNumber;
import com.example.calculator.CalcOperator;
import com.example.calculator.TextDisplay;

/**
 * class:
 *      - control each buttons function.
 *      - all private methods can used by calling wrap method(named call-).
 *      - all values from other classes is called as local value in each method, since they have to initialise at every phase.
 * methods:
 * - clickNumberButton: control numbers button(0-9 and 00).
 *      allow input any number.
 * - clickOperatorButton: control arithmetic operators button(+, -, *, /).
 *      1. allow input any arithmetic operator.
 *      2. allow input any number after input "=".
 * - clickEqualsButton: control the equals button(=).
 *      get the calculate result.
 * - clickAcButton: control the AC button.
 *      clear the display.
 * **/
public class ButtonController_impl implements ButtonController {
    private final CalcNumber calcNumber;
    private final CalcOperator calcOperator;
    private final TextDisplay textDisplay;

    public ButtonController_impl(CalcNumber calcNumber, CalcOperator calcOperator, TextDisplay textDisplay) {
        this.calcNumber = calcNumber;
        this.calcOperator = calcOperator;
        this.textDisplay = textDisplay;
    }

    @Override
    public void callNumberButton(String num) {
        clickNumberButton(num);
    }

    @Override
    public void callOperatorButton(String op) {
        clickOperatorButton(op);
    }

    @Override
    public void callEqualsButton() {
        clickEqualsButton();
    }

    @Override
    public void callAcButton() {
        clickAcButton();
    }

    /**
     * method: define the click function for number buttons
     * @ Param: String num
     * - set to input any number
     * **/
    private void clickNumberButton(String num) {
        String operator = calcOperator.getOperator();
        boolean isInput = calcNumber.getIsInput();
        String currentNum = calcNumber.getCurrentNum();
        calcNumber.setIsInput(true);

        if (operator.equals("=")) {
            calcNumber.setCurrentNum(num);
            calcNumber.setStoredNum(0);
            calcOperator.setOperator(""); // once clear the arithmetic operator.
            calcNumber.setCalcResult(0); // once clear the calculate result.
        } else if (currentNum.equals("0") && (num.equals("0") || num.equals("00"))) { // if only 0 is on the display, ignored the input 0 or 00 again.
            return;
        } else if (!isInput) { // the first input number after a arithmetic operator.
            calcNumber.setCurrentNum(num); // override currentNum if you have been input a arithmetic number.
        } else {
            calcNumber.setCurrentNum(currentNum + num);
        }
        calcNumber.setIsInput(true); // any number is inputted.
        textDisplay.setTextDisplay(textDisplay.callUpdateDisplay());
    }

    /**
     * method: define the click function for arithmetic operator buttons
     * @ Param: String op
     * - set to input any arithmetic operator
     * **/
    private void clickOperatorButton(String op){
        String operator = calcOperator.getOperator();
        boolean isInput = calcNumber.getIsInput();
        String currentNum = calcNumber.getCurrentNum();
        double cNum = Double.parseDouble(currentNum); // String currentNumber convert to double.
        double calcResult = calcNumber.getCalcResult();

        if (operator.equals("=")) { // allow to calculate further input any number after input "=".
            calcNumber.setStoredNum(calcResult); // store calculate result for next calculate.
        } else if (operator.isEmpty() || isInput) { // input first number.
            calcNumber.setStoredNum(cNum); // store inputted number.
            if (!operator.isEmpty()) {
                calcNumber.callDoCalc(calcOperator); // calculate.
                // get "new" calculate result.
                calcNumber.setStoredNum(calcResult);
            }
        }
        calcOperator.setOperator(op); // define inputted arithmetic operator.
        calcNumber.setIsInput(false); // set input state "wait for next input numbers" after input arithmetic operator
        // show calculate step
        textDisplay.setTextDisplay(textDisplay.callUpdateDisplay());
    }

    /**
     * method: define the click function for the "=" button.
     * **/
    private void clickEqualsButton() {
        double calcResult = calcNumber.getCalcResult();
        String currentNum = calcNumber.getCurrentNum();
        double cNum = Double.parseDouble(currentNum);
        String operator = calcOperator.getOperator();

        if (!operator.isEmpty() && !operator.equals("=")) { // if min. a arithmetic operator and "=" are there.
            calcNumber.callDoCalc(calcOperator); // execute calculate
        } else {
            calcNumber.setCalcResult(cNum);
        }

        calcNumber.setCurrentNum(textDisplay.callFormatNumber(calcResult)); // the calculate result is stored in currentNum and show this on the display.
        calcNumber.setStoredNum(0); // reset stored number to next calculate.
        calcOperator.setOperator("="); // set the operator as "=".
        calcNumber.setIsInput(false); // input state is false after showing on the display.
        textDisplay.setTextDisplay(textDisplay.callUpdateDisplay()); // the calculate result shows on the display.
    }

    /**
     * method: define the click function for the AC button.
     * **/
    private void clickAcButton() {
        textDisplay.clearDisplay(); // reset display.
        textDisplay.setTextDisplay(textDisplay.callUpdateDisplay()); // show cleared display.
    }

}
