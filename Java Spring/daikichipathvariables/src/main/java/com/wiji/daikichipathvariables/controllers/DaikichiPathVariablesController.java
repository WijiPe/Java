package com.wiji.daikichipathvariables.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiPathVariablesController {
	@GetMapping("/travel/{city}")
	public String travel(@PathVariable("city") String city){
    	return "Congratulations! You will soon travel to " + city + ".";
    }
	@GetMapping("/lotto/{number}")
	public String lotto(@PathVariable("number") String number){
		if(Integer.parseInt(number) % 2 == 0) {
			return "You will take a grand journey in the near future, but be wary of temping offers.";
		}
		return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
	}
}
