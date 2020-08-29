package com.example.payment.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Card {
    protected String Name;
    protected String Number;
    protected String CardHolder;
    protected Date ExpirationDate;
    static double MaximumPaymentValue = 1000.0;

    public void ShowCardInformation(){
        System.out.println("Card name");
        System.out.println(this.Name);
    }

    public String CardName(){
        return this.Name;
    }

    public boolean ValidCard(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
        return (sdf.format(this.ExpirationDate).compareTo(sdf.format(new Date())) < 0) ? false: true;
    }

    public boolean ValidTransaction(double PaymentValue){
        return PaymentValue < MaximumPaymentValue && PaymentValue > 0;
    }

}
