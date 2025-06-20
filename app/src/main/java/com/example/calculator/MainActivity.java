package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.calculator.impl.CalcNumber_impl;
import com.example.calculator.impl.CalcOperator_impl;
import com.example.calculator.impl.TextTextDisplay_impl;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private CalcNumber calcNumber;
    private CalcOperator calcOperator;
    private TextDisplay textDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // instance
        calcNumber = new CalcNumber_impl();
        calcOperator = new CalcOperator_impl();
        textDisplay = new TextTextDisplay_impl(calcNumber, calcOperator);

        textView = findViewById(R.id.text);
        setUpButtons(R.id.b00, "00" ,"");
        setUpButtons(R.id.b0, "0", "");
        setUpButtons(R.id.b1, "1", "");
        setUpButtons(R.id.b2, "2", "");
        setUpButtons(R.id.b3, "3", "");
        setUpButtons(R.id.b4, "4", "");
        setUpButtons(R.id.b5, "5", "");
        setUpButtons(R.id.b6, "6", "");
        setUpButtons(R.id.b7, "7", "");
        setUpButtons(R.id.b8, "8", "");
        setUpButtons(R.id.b9, "9", "");

        setUpButtons(R.id.plus, "", "+");
        setUpButtons(R.id.min, "", "-");
        setUpButtons(R.id.mul, "", "*");
        setUpButtons(R.id.div, "", "/");

        setUpButtons(R.id.equal, "", "=");
        setUpButtons(R.id.ac, "","");
    }

    /**
     * method: set up Numbers buttons
     * @ Param: int bId
     *     - every numbers buttons id on the apps xml. ex: bId = b00 => button "00".
     * @ Param: final String num, final String op
     *     - to choose a button from numbers- and operators buttons
     *     - the showing buttons by String. ex: num = "00" => button "00". op = "+" => button "+".
     * **/
    private void setUpButtons(int bId, final String num, final String op) {
        Button button = findViewById(bId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcNumber.callNumberButton(num);
                calcOperator.callOperatorButton(op);
                textDisplay.callAcButton();
            }
        });

    }
}