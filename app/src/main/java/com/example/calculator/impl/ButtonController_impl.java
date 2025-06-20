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
    public void callAcButton() {
        clickAcButton();
    }

    private void clickNumberButton(String num) {
        String operator = calcOperator.getOperator();
        boolean isInput = calcNumber.getIsInput();
        String currentNum = calcNumber.getCurrentNum();
        calcNumber.setIsInput(true);

        if (currentNum.isEmpty() || operator.isEmpty()) { // if you input still nothing.
            calcNumber.setCurrentNum(num); // input num
        } else if (!currentNum.isEmpty() && operator.equals("=")) {

        }

    }

    private void clickOperatorButton(String op){

    }

    private void clickAcButton() {}

}
