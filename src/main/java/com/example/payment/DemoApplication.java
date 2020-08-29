package com.example.payment;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

import com.example.payment.model.Visa;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);
		Date MyCardDate = new Date();
		Visa MyCard = new Visa("123456","Juan Diaz",MyCardDate);
		MyCard.ShowCardInformation();
		Visa MyCard2 = new Visa("123456","Juan Diaz",MyCardDate);
		MyCard2.ShowCardInformation();
		if (MyCard.EqualstoCard(MyCard2))
			System.out.printf("Equals");
		else System.out.printf("No Equals ");
	}

}
