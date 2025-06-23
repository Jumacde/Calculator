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
            calcOperator.setOperator("");
            calcNumber.setCalcResult(0);
            textDisplay.setTextDisplay(currentNum);
            return; 
        }

        // if only 0 is on the display, ignored the input 0 or 00 again.
        if (currentNum.equals("0") && (num.equals("0") || (num.equals("00")))) {
            return;
        }


    }

    private void clickOperatorButton(String op){

    }

    private void clickEqualsButton() {}

    private void clickAcButton() {}

}
