package com.example.root.hasher;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static Button button_inp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OnClickButtonListener();
    }
    public void OnClickButtonListener(){
        button_inp=(Button)findViewById(R.id.button);
        button_inp.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent("com.example.root.hasher.SecondActivity");
                        startActivity(intent);
                    }
                }
        );
    }
    public void onButtonClick(View a) {
        if (a.getId() == R.id.BAdd) {
            EditText a1 = (EditText) findViewById(R.id.number1);
            EditText a2 = (EditText) findViewById(R.id.number2);
            TextView t = (TextView) findViewById(R.id.ans);
            double num1, num2;
            num1 = Double.parseDouble(a1.getText().toString());
            num2 = Double.parseDouble(a2.getText().toString());
            double answer = num1 + num2;
            t.setText(Double.toString(answer));
        }
        if (a.getId() == R.id.BMul) {
            EditText a1 = (EditText) findViewById(R.id.number1);
            EditText a2 = (EditText) findViewById(R.id.number2);
            TextView t = (TextView) findViewById(R.id.ans);
            double num1, num2;
            num1 = Double.parseDouble(a1.getText().toString());
            num2 = Double.parseDouble(a2.getText().toString());
            double answer = num1 * num2;
            t.setText(Double.toString(answer));
        }
        if (a.getId() == R.id.BSub) {
            EditText a1 = (EditText) findViewById(R.id.number1);
            EditText a2 = (EditText) findViewById(R.id.number2);
            TextView t = (TextView) findViewById(R.id.ans);
            double num1, num2;
            num1 = Double.parseDouble(a1.getText().toString());
            num2 = Double.parseDouble(a2.getText().toString());
            double answer = num1 - num2;
            t.setText(Double.toString(answer));
        }
        if (a.getId() == R.id.BDiv) {
            EditText a1 = (EditText) findViewById(R.id.number1);
            EditText a2 = (EditText) findViewById(R.id.number2);
            TextView t = (TextView) findViewById(R.id.ans);
            double num1, num2;
            num1 = Double.parseDouble(a1.getText().toString());
            num2 = Double.parseDouble(a2.getText().toString());
            double answer = num1 / num2;
            t.setText(Double.toString(answer));
        }
    }
}



