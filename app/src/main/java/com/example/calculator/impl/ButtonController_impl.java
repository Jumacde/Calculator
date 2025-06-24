package com.example.calculator.impl;

import com.example.calculator.ButtonController;
import com.example.calculator.CalcNumber;
import com.example.calculator.CalcOperator;
import com.example.calculator.TextDisplay;

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
     * - set a any input number
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

    private void clickOperatorButton(String op){
        String operator = calcOperator.getOperator();
        boolean isInput = calcNumber.getIsInput();
        String currentNum = calcNumber.getCurrentNum();
        double cNum = Double.parseDouble(currentNum); // String currentNumber convert to double.
        double calcResult = calcNumber.getCalcResult();

        if (operator.isEmpty() || isInput) {
            calcNumber.setStoredNum(cNum);
            if (!operator.isEmpty()) {
                calcNumber.callDoCalc(calcOperator);
                calcNumber.setStoredNum(calcResult);
            }
        }
        calcOperator.setOperator(op); // define inputted arithmetic operator.
        calcNumber.setIsInput(false); // set input state "wait for next input numbers" after input arithmetic operator
        // show calculate step
        textDisplay.setTextDisplay(textDisplay.callUpdateDisplay());
    }

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

    private void clickAcButton() {
        textDisplay.clearDisplay();
        textDisplay.setTextDisplay(textDisplay.callUpdateDisplay());
    }

}
