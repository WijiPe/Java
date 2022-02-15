package com.wiji.displaydate.controllers;



import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DisplayDateController {
	
	@GetMapping("/")
	public String index(Model model) {
		return "Index.jsp";
	}
	
	@GetMapping("/time")
	public String time(Model model) {
		String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm a"));
//		@DateTimeFormat(pattern="HH:mm a");
		
		model.addAttribute("time", time);
		
		return "time.jsp";
	}
	
	@GetMapping("/date")
	public String date(Model model) {
//		String date = LocalDate.now().format(DateTimeFormatter.ofPattern("EEEE,d MMMM, yyyy")); 
		Date date = new Date();
		model.addAttribute("date", date);
		
		return "date.jsp";
	}
}

