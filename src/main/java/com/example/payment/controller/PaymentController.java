package com.example.payment.controller;

import java.util.Arrays;

import com.example.payment.DemoApplication;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @GetMapping(value = "/operation-rate", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
            MediaType.APPLICATION_JSON_VALUE })

    public ResponseEntity<Object> processOperationRate(@RequestBody TransactionRateProcessModel transactionDetails) {
        new DemoApplication();
        if (missing_params(transactionDetails))
            return ResponseEntity.badRequest().body("Missing parameters");
        else if (invalid_params(transactionDetails))
            return ResponseEntity.unprocessableEntity().body("Invalid parameters");
        double amountRateValue = DemoApplication.CalculateOperationRate(transactionDetails.getCardName(),
        Double.parseDouble(transactionDetails.getAmount()));
        return new ResponseEntity<Object>(new amountRate(Double.toString(amountRateValue)), HttpStatus.OK);

    }
    public boolean missing_params(TransactionRateProcessModel bodyParams){
        return ((bodyParams.getCardName()==null) || (bodyParams.getAmount() == null));
    }

    public boolean invalid_params(TransactionRateProcessModel bodyParams){
        String[] validCards = {"Visa","Amex","Nara"};
        boolean validCard = Arrays.stream(validCards).anyMatch(bodyParams.getCardName()::equals);
        boolean validAmount =  Double.parseDouble(bodyParams.getAmount())>0;
        return !(validCard && validAmount);
    }
}