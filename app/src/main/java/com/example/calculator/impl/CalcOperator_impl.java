package com.example.calculator.impl;

import com.example.calculator.CalcOperator;

/**
 * class: control the equal(=)- and arithmetic operators(+, -, *, /).
 **/
public class CalcOperator_impl implements CalcOperator {
    private String operator;

    public CalcOperator_impl() {
        this.operator = "";
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
}
