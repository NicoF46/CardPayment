package com.example.payment.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Amex extends Card {

    public Amex( String Number, String CardHolder, Date ExpDate) {
        if (!ValidCardNumber(Number)) 
            throw new IllegalArgumentException("Number Param must be valid a Number");
        this.Name = "Amex";
        this.Number = Number;
        this.CardHolder = CardHolder;
        this.ExpirationDate = ExpDate;
    }

    public double OperationRateValue(Date date){
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue();
        return month*0.1;
    }


}