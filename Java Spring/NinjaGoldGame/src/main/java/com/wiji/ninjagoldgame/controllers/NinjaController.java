package com.wiji.ninjagoldgame.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Random;

@Controller
public class NinjaController {
	
	private Random random = new Random();
	
	@GetMapping("/gold")
	public String home(HttpSession session) {
		if(session.getAttribute("gold")==null) {
			session.setAttribute("gold", 0);
		}
		if(session.getAttribute("activities") == null) {
			session.setAttribute("activities",  new ArrayList<String>());
		}
		
		return "gold.jsp";
		
	}
	
	@PostMapping("/process")
	public String submit(HttpSession session,
			@RequestParam(value="place") String place) {
		
			String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm a"));
			String date = LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
			
    	if(place.equals("farm")) {
    		Integer tempGold = (Integer) session.getAttribute("gold");
    		Integer randomGold = (Integer) random.nextInt(10)+10;
    		session.setAttribute("gold", tempGold+randomGold);
    		if(tempGold < -1000){
    			return "redirect:/prison";
    		}
			ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
    		activities.add("You entered a farm and earned " + randomGold + " gold." + "(" + date+ " "+ time + ")");
    		session.setAttribute("activities",  activities);
    	}else if(place.equals("cave")) {
    		Integer tempGold = (Integer) session.getAttribute("gold");
    		Integer randomGold = (Integer) random.nextInt(5)+5;
    		session.setAttribute("gold", tempGold+ randomGold);
    		if(tempGold < -1000){
    			return "redirect:/prison";
    		}
    		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
    		activities.add("You entered a cave and earned " + randomGold + " gold." + "(" + date+ " "+ time + ")");
    		session.setAttribute("activities",  activities);
    	}else if(place.equals("house")) {
    		Integer tempGold = (Integer) session.getAttribute("gold");
    		Integer randomGold = (Integer) random.nextInt(3)+2;
    		session.setAttribute("gold", tempGold+randomGold);
    		if(tempGold < -1000){
    			return "redirect:/prison";
    		}
    		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
    		activities.add("You entered a house and earned " + randomGold + " gold." + "(" + date+ " "+ time + ")");
    		session.setAttribute("activities",  activities);
    	}else if(place.equals("casino")) {
    		Integer tempGold = (Integer) session.getAttribute("gold");
    		Integer randomGold = (Integer) random.nextInt(100)-50;
    		session.setAttribute("gold", tempGold+randomGold);
    		if(tempGold < -1000){
    			return "redirect:/prison";
    		}
    		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
    		if(randomGold < 0) {
    			activities.add("You entered a casino and lost " + Math.abs(randomGold) + " gold." + "(" + date+ " "+ time + ")");
    			}else{
    				activities.add("You entered a casino and earned " + randomGold + " gold." + "(" + date+ " "+ time + ")");
    			}
    		session.setAttribute("activities",  activities);
    	}else if(place.equals("spa")) {
    		Integer tempGold = (Integer) session.getAttribute("gold");
    		Integer randomGold = (Integer) random.nextInt(15)+5;
    		session.setAttribute("gold", tempGold-randomGold);
    		if(tempGold < -100){
    			return "redirect:/prison";
    		}
    		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
    		activities.add("You entered a spa and lost " + Math.abs(randomGold) + " gold." + "(" + date+ " "+ time + ")");
    		session.setAttribute("activities",  activities);
    	}
    	return "redirect:/gold";
	}
	
	@GetMapping("/gold/reset")
	public String reset(HttpSession session) {
		session.setAttribute("gold", null);
		session.setAttribute("activities", null);
			
		return "redirect:/gold";
	}
	
	@GetMapping("/prison")
	public String prison() {
		return "prison.jsp";
	}
}	
