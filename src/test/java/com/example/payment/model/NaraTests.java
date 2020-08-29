package com.example.payment.model;

import org.junit.jupiter.api.Test;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NaraTests {

    @Test
    void setTheCardNameCorrectly() {
        Nara MyCard = new Nara("123456", "Juan Diaz", new Date());
        assertEquals("Nara", MyCard.CardName());
    }

    @Test
    void setACardAsValidWithAExpiredFutureDate() throws ParseException {
        Date MyCardExpirationDate = new SimpleDateFormat("yyyy MM dd").parse("2021 12 31");
        Nara MyCard = new Nara("123456","Juan Diaz", MyCardExpirationDate);
        assertTrue(MyCard.ValidCard());
    }

    @Test
    void setACardAsExpiredWithAExpiredPassedDate() throws ParseException {
        Date MyCardExpirationDate = new SimpleDateFormat("yyyy MM dd").parse("2020 01 31");
        Nara MyCard = new Nara("123456","Juan Diaz", MyCardExpirationDate);
        assertFalse(MyCard.ValidCard());
    }

    @Test
    void setACardAsValidWithAExpiredDateToday() throws ParseException {
        Date MyCardExpirationDate = new Date();
        Nara MyCard = new Nara("123456","Juan Diaz", MyCardExpirationDate);
        assertTrue(MyCard.ValidCard());
    }


    @Test
    void recognizeInvalidTransactionWithValueUpperTheLimit(){
        double PaymentValue = 1001.0;
        Nara MyCard = new Nara("123456", "Juan Diaz", new Date());
        assertFalse(MyCard.ValidTransaction(PaymentValue));
    }

    @Test
    void recognizeInvalidTransactionWithValueAtTheLimit(){
        double PaymentValue = 1000.0;
        Nara MyCard = new Nara("123456", "Juan Diaz", new Date());
        assertFalse(MyCard.ValidTransaction(PaymentValue));
    }

    @Test
    void recognizeValidTransactionWithValueInRange(){
        double PaymentValue = 100.0;
        Nara MyCard = new Nara("123456", "Juan Diaz", new Date());
        assertTrue(MyCard.ValidTransaction(PaymentValue));
    }

    @Test
    void CompareNaraCardWithOtherNaraWithTheSameValues(){
        Date MyCardDate = new Date();
		Nara MyCard1 = new Nara("123456","Juan Diaz",MyCardDate);
        Nara MyCard2 = new Nara("123456","Juan Diaz",MyCardDate);
        assertTrue(MyCard1.EqualstoCard(MyCard2));
    }

    @Test
    void CompareNaraCardWithOtherNaraWithTheDifferentNumber(){
        Date MyCardDate = new Date();
		Nara MyCard1 = new Nara("123456","Juan Diaz",MyCardDate);
        Nara MyCard2 = new Nara("123457","Juan Diaz",MyCardDate);
        assertFalse(MyCard1.EqualstoCard(MyCard2));
    }

    @Test
    void CalculateRateCorrectly() throws ParseException {
        Date date = new SimpleDateFormat("yyyy MM dd").parse("2020 09 10");
        Nara MyCard = new Nara("123456","Juan Diaz",date);
        double ExpectedRate = 10*0.5;
        assertEquals(MyCard.OperationRateValue(date),ExpectedRate);
    }

    @Test
    void CreateCardWithInvalidNumberThrowException() throws ParseException {
        assertThrows(IllegalArgumentException.class, () -> {new Nara("1234AB56", "Juan Diaz", new Date());
        });
    }
}