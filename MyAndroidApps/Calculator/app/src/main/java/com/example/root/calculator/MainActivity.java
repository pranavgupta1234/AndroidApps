package com.example.root.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static Button button_inp;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OnClickButtonListener();
        toolbar=(Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }
    public boolean OnCreateOptionsMenu (final Menu menu) {
        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.menu_main,menu);
        return true;
    }
    public  boolean OnOptionsItemSelected(MenuItem item){
        int res_id=item.getItemId();
        if(res_id==R.id.action_settings)
        {
            Toast.makeText(getApplicationContext(),"You selected Settings Option",Toast.LENGTH_LONG).show();
        }
        return true;
    }
    public void OnClickButtonListener(){
        button_inp=(Button)findViewById(R.id.button1);
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
