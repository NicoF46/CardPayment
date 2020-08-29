package com.example.payment.model;

import org.junit.jupiter.api.Test;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AmexTests {

    @Test
    void setTheCardNameCorrectly() {
        Amex MyCard = new Amex("123456", "Juan Diaz", new Date());
        assertEquals("Amex", MyCard.CardName());
    }

    @Test
    void setACardAsValidWithAExpiredFutureDate() throws ParseException {
        Date MyCardExpirationDate = new SimpleDateFormat("yyyy MM dd").parse("2021 12 31");
        Amex MyCard = new Amex("123456","Juan Diaz", MyCardExpirationDate);
        assertTrue(MyCard.ValidCard());
    }

    @Test
    void setACardAsExpiredWithAExpiredPassedDate() throws ParseException {
        Date MyCardExpirationDate = new SimpleDateFormat("yyyy MM dd").parse("2020 01 31");
        Amex MyCard = new Amex("123456","Juan Diaz", MyCardExpirationDate);
        assertFalse(MyCard.ValidCard());
    }

    @Test
    void setACardAsValidWithAExpiredDateToday() throws ParseException {
        Date MyCardExpirationDate = new Date();
        Amex MyCard = new Amex("123456","Juan Diaz", MyCardExpirationDate);
        assertTrue(MyCard.ValidCard());
    }


    @Test
    void recognizeInvalidTransactionWithValueUpperTheLimit(){
        double PaymentValue = 1001.0;
        Amex MyCard = new Amex("123456", "Juan Diaz", new Date());
        assertFalse(MyCard.ValidTransaction(PaymentValue));
    }

    @Test
    void recognizeInvalidTransactionWithValueAtTheLimit(){
        double PaymentValue = 1000.0;
        Amex MyCard = new Amex("123456", "Juan Diaz", new Date());
        assertFalse(MyCard.ValidTransaction(PaymentValue));
    }

    @Test
    void recognizeValidTransactionWithValueInRange(){
        double PaymentValue = 100.0;
        Amex MyCard = new Amex("123456", "Juan Diaz", new Date());
        assertTrue(MyCard.ValidTransaction(PaymentValue));
    }

    @Test
    void CompareAmexCardWithOtherAmexWithTheSameValues(){
        Date MyCardDate = new Date();
		Amex MyCard1 = new Amex("123456","Juan Diaz",MyCardDate);
        Amex MyCard2 = new Amex("123456","Juan Diaz",MyCardDate);
        assertTrue(MyCard1.EqualstoCard(MyCard2));
    }

    @Test
    void CompareAmexCardWithOtherAmexWithTheDifferentNumber(){
        Date MyCardDate = new Date();
		Amex MyCard1 = new Amex("123456","Juan Diaz",MyCardDate);
        Amex MyCard2 = new Amex("123457","Juan Diaz",MyCardDate);
        assertFalse(MyCard1.EqualstoCard(MyCard2));
    }

    @Test
    void CalculateRateCorrectly() throws ParseException {
        Date date = new SimpleDateFormat("yyyy MM dd").parse("2020 09 10");
        Amex MyCard = new Amex("123456","Juan Diaz",date);
        double ExpectedRate = 9*0.1;
        assertEquals(MyCard.OperationRateValue(date),ExpectedRate);
    }
}