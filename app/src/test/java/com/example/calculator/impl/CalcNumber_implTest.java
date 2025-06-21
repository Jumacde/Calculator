package com.example.calculator.impl;

import com.example.calculator.CalcNumber;
import com.example.calculator.CalcOperator;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class CalcNumber_implTest extends TestCase {
    private CalcNumber calcNumber;
    private CalcOperator mockCalcOperator;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        calcNumber = new CalcNumber_impl();
        mockCalcOperator = new CalcOperator() {
            String operatorValue = "";
            @Override
            public String getOperator() {
                return operatorValue;
            }

            @Override
            public void setOperator(String operator) {
                this.operatorValue = operator;
            }
        };
    }

    @Test
    public void testGetCurrentNum() {
        assertEquals("0", calcNumber.getCurrentNum());
    }

    @Test
    public void testGetStoredNum() {
        assertEquals(0.0, calcNumber.getStoredNum(), 0.001);
    }

    @Test
    public void testGetIsInput() {
        assertFalse(calcNumber.getIsInput());
    }

    @Test
    public void testSetCurrentNum() {
        calcNumber.setCurrentNum("123");
        assertEquals("123", calcNumber.getCurrentNum());
        assertTrue(calcNumber.getIsInput());
    }

    @Test
    public void testSetStoredNum() {
        calcNumber.setStoredNum(10.5);
        assertEquals(10.5, calcNumber.getStoredNum(), 0.001);
    }

    @Test
    public void testSetIsInput() {
        calcNumber.setIsInput(true);
        assertTrue(calcNumber.getIsInput());
        calcNumber.setIsInput(false);
        assertFalse(calcNumber.getIsInput());
    }

    @Test
    public void testCallDoCalc() {
        calcNumber.setStoredNum(5.0);
        calcNumber.setCurrentNum("3.0");
        double cNum = Double.parseDouble(calcNumber.getCurrentNum());
        mockCalcOperator.setOperator("+");
        calcNumber.setIsInput(true);

        calcNumber.callDoCalc(mockCalcOperator);
    }
}