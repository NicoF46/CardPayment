package com.example.payment;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Date;

import com.example.payment.model.Visa;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);
		Visa MyCard = new Visa("123456","Juan Diaz",new Date());
		MyCard.ShowCardInformation();
	}

}
