package com.example.calculator;

import android.os.Bundle;
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

        calcNumber = new CalcNumber_impl();
        calcOperator = new CalcOperator_impl();
        textDisplay = new TextTextDisplay_impl(calcNumber, calcOperator);

    }
}