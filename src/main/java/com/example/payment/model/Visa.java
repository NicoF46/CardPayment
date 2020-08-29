package com.example.payment.model;

import java.util.Date;

public class Visa extends Card {

    public Visa( String Number, String CardHolder, Date ExpDate) {
        this.Name = "Visa";
        this.Number = Number;
        this.CardHolder = CardHolder;
        this.ExpirationDate = ExpDate;
    }

}