package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.calculator.impl.ButtonController_impl;
import com.example.calculator.impl.CalcNumber_impl;
import com.example.calculator.impl.CalcOperator_impl;
import com.example.calculator.impl.TextDisplay_impl;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private CalcNumber calcNumber;
    private CalcOperator calcOperator;
    private TextDisplay textDisplay;
    private ButtonController buttonController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // instance
        calcNumber = new CalcNumber_impl();
        calcOperator = new CalcOperator_impl();
        textDisplay = new TextDisplay_impl(calcNumber, calcOperator);
        buttonController = new ButtonController_impl(calcNumber, calcOperator, textDisplay);

        textView = findViewById(R.id.text);
        setUpNumbersButtons(R.id.b00, "00");
        setUpNumbersButtons(R.id.b0, "0");
        setUpNumbersButtons(R.id.b1, "1");
        setUpNumbersButtons(R.id.b2, "2");
        setUpNumbersButtons(R.id.b3, "3");
        setUpNumbersButtons(R.id.b4, "4");
        setUpNumbersButtons(R.id.b5, "5");
        setUpNumbersButtons(R.id.b6, "6");
        setUpNumbersButtons(R.id.b7, "7");
        setUpNumbersButtons(R.id.b8, "8");
        setUpNumbersButtons(R.id.b9, "9");

        setUpOperatorsButtons(R.id.plus, "+");
        setUpOperatorsButtons(R.id.min, "-");
        setUpOperatorsButtons(R.id.mul, "*");
        setUpOperatorsButtons(R.id.div, "/");

        setUpEqualsButtons(R.id.equal);
        setUpACsButtons(R.id.ac);
    }

    // method: update display
    private void updateDisplay() {
        textView.setText(textDisplay.getTextDisplay());
    }

    /**
     * method: set up Numbers buttons
     * @ Param: int bId
     *     - every numbers buttons id on the apps xml. ex: bId = b00 => button "00".
     * @ Param: final String num, final String op
     *     - to choose a button from numbers- and operators buttons
     *     - the showing buttons by String. ex: num = "00" => button "00". op = "+" => button "+".
     * **/
    private void setUpNumbersButtons(int bId, final String num) {
        Button button = findViewById(bId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonController.callNumberButton(num);
                updateDisplay();
            }
        });
    }

    private void setUpOperatorsButtons(int bId, final String op) {
        Button button = findViewById(bId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonController.callOperatorButton(op);
                updateDisplay();
            }
        });
    }

    private void setUpEqualsButtons(int bId) {
        Button button = findViewById(bId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonController.callEqualsButton();
                updateDisplay();
            }
        });
    }

    private void setUpACsButtons(int bId) {
        Button button = findViewById(bId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonController.callAcButton();
                updateDisplay();
            }
        });
    }

}