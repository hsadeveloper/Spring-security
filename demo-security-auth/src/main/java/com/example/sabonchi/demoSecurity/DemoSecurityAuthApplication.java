package com.example.sabonchi.demoSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.sabonchi.demoSecurity.entity.Card;
import com.example.sabonchi.demoSecurity.repository.CardRepository;

@SpringBootApplication
public class DemoSecurityAuthApplication  implements CommandLineRunner{

	public static void main(String[] args)   {
		SpringApplication.run(DemoSecurityAuthApplication.class, args);
	}
	
	
	@Autowired
	private CardRepository repository;
	

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("####################### Adding Record Objects ########################");
		   Card card1 = new Card ( "FaceBook","1z2y3x", "new password");
		   Card card2 = new Card ( "Gmail","1z2y3x",  "updates password");
		   Card card3 = new Card ( "Gas-Company","1z2y3x", "need to be updated recently");
		   repository.save(card1);
		   repository.save(card2);
		   repository.save(card3);
		
		
	}
	
	
	
}

