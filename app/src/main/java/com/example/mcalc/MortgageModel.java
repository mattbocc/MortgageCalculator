package com.example.mcalc;

import java.io.PrintStream;
import java.util.Scanner;

public class MortgageModel {
    private double principle;
    private double amortization;
    private double interest;

    public MortgageModel(String p, String a, String i){
        this.principle = Double.parseDouble(p);
        this.amortization = Double.parseDouble(a);
        this.interest = Double.parseDouble(i);
    }
    public String getPayment(){

        double rCalc = (this.interest/(1200)); //r a.k.a interest
        double amortizationCalc = (this.amortization*12)*(-1); //-n a.k.a amortization -300
        double numerator = rCalc*(this.principle); //rP 160416.67
        double denominatorWithoutPow = (1+rCalc);//(1+r) 1.23
        double denominatorWithPow = Math.pow(denominatorWithoutPow, amortizationCalc);//(1+r)^-n very small decimal
        double payment = (numerator/(1-denominatorWithPow));//whole eqn

        String result = String.format("%.2f", payment);//change back payment, from numerator
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PrintStream output = System.out;

        MortgageModel testModel = new MortgageModel("700000","25", "2.75");
        String myModel = testModel.getPayment();
        output.println(myModel);

    }
}
