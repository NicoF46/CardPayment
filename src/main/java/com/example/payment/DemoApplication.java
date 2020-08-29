package com.example.payment;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

import com.example.payment.model.Amex;
import com.example.payment.model.Card;
import com.example.payment.model.Nara;
import com.example.payment.model.Visa;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);
		Date MyCardDate = new Date();
		Visa MyCard1 = new Visa("123456","Juan Diaz",MyCardDate);
		DisplayCardInformation(MyCard1);
		Amex MyCard2 = new Amex("123456","Juan Diaz",MyCardDate);
		DisplayCardInformation(MyCard2);
		Nara MyCard3 = new Nara("123456","Juan Diaz",MyCardDate);
		DisplayCardInformation(MyCard3);
		if (ValidCard(MyCard1))
			System.out.printf("Valid");
		else 
			System.out.printf("No Valid ");
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
