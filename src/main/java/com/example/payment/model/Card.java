package com.example.payment.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Card {
    protected String Name;
    protected String Number;
    protected String CardHolder;
    protected Date ExpirationDate;
    static double MaximumPaymentValue = 1000.0;
    static double DefaultRateValue = 1.0;

    public void ShowCardInformation(){
        System.out.printf(" Card Name: %s, Number: %s , CardHolder: %s, Expiration Date: %s\n" ,
            this.Name,this.Number,this.CardHolder,this.ExpirationDate.toString());
    }

    public String CardName(){
        return this.Name;
    }

    public boolean ValidCard(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd");   
        return (sdf.format(this.ExpirationDate).compareTo(sdf.format(new Date())) < 0) ? false: true;
    }

    public boolean ValidTransaction(double PaymentValue){
        return PaymentValue < MaximumPaymentValue && PaymentValue > 0;
    }

    public boolean EqualstoCard(Card ComparisonCard){
        return (this.Name == ComparisonCard.Name && this.Number == ComparisonCard.Number && this.CardHolder == ComparisonCard.CardHolder
             && this.ExpirationDate == ComparisonCard.ExpirationDate);  
    }

    public double OperationRateValue(Date date){
        return DefaultRateValue;
    }



}
