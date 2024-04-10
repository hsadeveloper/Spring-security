package com.example.sabonchi.demoSecurity.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sabonchi.demoSecurity.entity.Card;
import com.example.sabonchi.demoSecurity.repository.CardRepository;



@RestController
@RequestMapping("/cards")
public class CardController {
	
	private final CardRepository repository;
	
	
	  public CardController(CardRepository repository) {
		super();
		this.repository = repository;
	}

	@GetMapping("/")
	    public String publicPage() {
		  
				String response=   """
					<html>
			            <body>
			              <p> Welecome to the private  page</p>
			              <p> Everyone should see this page </p>
			            </body>
			        </html> """;
				
				return response;
	    }

	    @GetMapping("/private")
	    public List <Card> privatePage() {
	        return repository.findAll();
	    }

}
