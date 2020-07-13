package com.example.mcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void buttonClicked (View V){
        EditText principleView = (EditText) findViewById(R.id.principleBox);
        String principle = principleView.getText().toString();

        EditText amortizationView = (EditText) findViewById(R.id.amortizationBox);
        String amortization = amortizationView.getText().toString();

        EditText interestView = (EditText) findViewById(R.id.interestBox);
        String interest = interestView.getText().toString();


        MortgageModel model = new MortgageModel(principle, amortization, interest);

        String answer = model.getPayment();
        ((TextView) findViewById(R.id.answer)).setText(answer);



    }

}
