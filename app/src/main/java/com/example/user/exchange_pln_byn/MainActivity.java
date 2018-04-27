package com.example.user.exchange_pln_byn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText startSum;
    private TextView nameRes;
    private TextView result;
    private Button btnUsd;
    private Button btnEuro;
    private Button btnByn;
    private float resultConv;
    private float sumPLN;
    private float[] koeff = {0.29f,0.24f,0.58f};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startSum = (EditText) findViewById(R.id.editSum);
        nameRes = (TextView) findViewById(R.id.textNameRes);
        result = (TextView) findViewById(R.id.result);
        btnUsd = (Button) findViewById(R.id.btnUSD);
        btnEuro = (Button) findViewById(R.id.btnEURO);
        btnByn = (Button) findViewById(R.id.btnBYN);


        btnUsd.setOnClickListener(this);
        btnEuro.setOnClickListener(this);
        btnByn.setOnClickListener(this);
    }

    public float converte(float koeff) {
        //Сумма злотых на входе
        sumPLN = Float.parseFloat(startSum.getText().toString());
        resultConv = sumPLN * koeff;
        return resultConv;
    }

    @Override
    public void onClick(View v) {

        String res;
        try {
            switch (v.getId()) {
                case R.id.btnUSD:
                    res = String.valueOf(converte(koeff[0]));
                    result.setText(res + " $");
                    break;
                case R.id.btnEURO:
                    res = String.valueOf(converte(koeff[1]));
                    result.setText(res + " €");
                    break;
                case R.id.btnBYN:
                    res = String.valueOf(converte(koeff[2]));
                    result.setText(res + " Br");
                    break;
            }
        } catch(Exception ex)
        {
            Toast.makeText(this,"Введите сумму в злотых",Toast.LENGTH_LONG).show();
        }

    }
}