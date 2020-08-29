package com.example.demo.model;

import org.junit.jupiter.api.Test;
import java.util.Date;

import com.example.payment.model.Visa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VisaTests {

    @Test
    void setTheCardNameCorrectly() {
        Visa MyCard = new Visa("123456", "Juan Diaz", new Date());
        assertEquals("Visa", MyCard.CardName());
    }

    @Test
    void setACardAsValidWithAExpiredFutureDate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date MyCardExpirationDate = sdf.parse("2021-12-31");
        Visa MyCard = new Visa("123456","Juan Diaz", MyCardExpirationDate);
        assertTrue(MyCard.ValidCard());
    }

    @Test
    void setACardAsExpiredWithAExpiredPassedDate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date MyCardExpirationDate = sdf.parse("2019-12-31");
        Visa MyCard = new Visa("123456","Juan Diaz", MyCardExpirationDate);
        assertFalse(MyCard.ValidCard());
    }

    @Test
    void setACardAsValidWithAExpiredDateToday() throws ParseException {
        Date MyCardExpirationDate = new Date();
        Visa MyCard = new Visa("123456","Juan Diaz", MyCardExpirationDate);
        assertTrue(MyCard.ValidCard());
    }


    @Test
    void recognizeInvalidTransactionWithValueUpperTheLimit(){
        double PaymentValue = 1001.0;
        Visa MyCard = new Visa("123456", "Juan Diaz", new Date());
        assertFalse(MyCard.ValidTransaction(PaymentValue));
    }

    @Test
    void recognizeInvalidTransactionWithValueAtTheLimit(){
        double PaymentValue = 1000.0;
        Visa MyCard = new Visa("123456", "Juan Diaz", new Date());
        assertFalse(MyCard.ValidTransaction(PaymentValue));
    }

    @Test
    void recognizeValidTransactionWithValueInRange(){
        double PaymentValue = 100.0;
        Visa MyCard = new Visa("123456", "Juan Diaz", new Date());
        assertTrue(MyCard.ValidTransaction(PaymentValue));
    }
}