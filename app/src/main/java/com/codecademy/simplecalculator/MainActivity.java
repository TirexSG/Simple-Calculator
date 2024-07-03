package com.codecademy.simplecalculator;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        final EditText firstNumber = findViewById(R.id.number1);
        final EditText secondNumber = findViewById(R.id.number2);
        final RadioGroup operators = findViewById(R.id.operators);
        final RadioButton addButton = findViewById(R.id.add);
        final RadioButton subtractButton = findViewById(R.id.subtract);
        final RadioButton multiplyButton = findViewById(R.id.multiply);
        final RadioButton divisionButton = findViewById(R.id.division);
        final Button equalsButton = findViewById(R.id.equals);
        final TextView result = findViewById(R.id.result);

        equalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstNumberText = firstNumber.getText().toString();
                String secondNumberText = secondNumber.getText().toString();

                if (firstNumberText.isEmpty() || secondNumberText.isEmpty()) {
                    result.setText(" ");
                    return;
                }
                double operatorButtonId = operators.getCheckedRadioButtonId();
                double firstNumberValue = Double.parseDouble(firstNumber.getText().toString());
                double secondNumberValue = Double.parseDouble(secondNumber.getText().toString());
                Double answer = null;
                if (operatorButtonId == addButton.getId()){
                    answer = firstNumberValue + secondNumberValue;
                } else if (operatorButtonId == subtractButton.getId()){
                    answer = firstNumberValue - secondNumberValue;
                } else if (operatorButtonId == multiplyButton.getId()) {
                    answer = firstNumberValue * secondNumberValue;
                } else if (operatorButtonId == divisionButton.getId()){
                    answer = firstNumberValue / secondNumberValue;
                }
                result.setText(answer.toString());
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });


    }
}