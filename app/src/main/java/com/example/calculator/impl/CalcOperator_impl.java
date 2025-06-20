package com.example.calculator.impl;

import com.example.calculator.CalcOperator;

public class CalcOperator_impl implements CalcOperator {
    private String operator;
    public CalcOperator_impl() {

    }

    // getter
    @Override
    public String getOperator() {
        return operator;
    }

    // setter
    @Override
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * wrap method
     * **/
    @Override
    public void callOperatorButton() {
        operatorButton();
    }

    private void operatorButton() {

    }

}
