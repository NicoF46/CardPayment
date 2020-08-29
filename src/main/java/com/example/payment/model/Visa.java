package com.example.payment.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Visa extends Card {

    public Visa( String Number, String CardHolder, Date ExpDate) {
        if (!ValidCardNumber(Number)) 
            throw new IllegalArgumentException("Number Param must be valid a Number");
        this.Name = "Visa";
        this.Number = Number;
        this.CardHolder = CardHolder;
        this.ExpirationDate = ExpDate;
    }

    public double OperationRateValue(Date date){
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue();
        double year = localDate.getYear()-2000;
        return year/month;
    }


}