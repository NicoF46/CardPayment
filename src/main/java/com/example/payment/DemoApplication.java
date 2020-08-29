package com.example.payment;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.example.payment.model.Amex;
import com.example.payment.model.Card;
import com.example.payment.model.Nara;
import com.example.payment.model.Visa;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);
		Date MyCardDate = new Date();
		Visa MyCard = new Visa("123456","Juan Diaz",MyCardDate);
		DisplayCardInformation(MyCard);
		Visa MyCard2 = new Visa("123456","Juan Diaz",MyCardDate);
		DisplayCardInformation(MyCard2);
		if (ValidCard(MyCard))
			System.out.printf("Valid");
		else System.out.printf("No Valid ");
		double valor = CalculateOperationRate("Nara",100);
		System.out.printf("Valor %f",valor );

	}

	private static void DisplayCardInformation(Card MyCard){
		MyCard.ShowCardInformation();
	}

	private static boolean ValidOperation(Card MyCard, double PaymentValue){
		return MyCard.ValidTransaction(PaymentValue);
	}

	private static boolean ValidCard(Card MyCard){
		return MyCard.ValidCard();
	}

	private static boolean EqualCards(Card FirstCard, Card SecondCard){
		return FirstCard.EqualstoCard(SecondCard);
	}

	private static double CalculateOperationRate(String CardName, double PaymentValue ){
		switch(CardName) {
			case "Visa":
				return new Visa("123456","Juan Diaz",new Date()).OperationRateValue(new Date())*PaymentValue/100;				
			case "Amex":
				return new Amex("123456","Juan Diaz",new Date()).OperationRateValue(new Date())*PaymentValue/100;
			case "Nara":
				return new Nara("123456","Juan Diaz",new Date()).OperationRateValue(new Date())*PaymentValue/100;
			default:
			  return 0;
		}
	}
}
