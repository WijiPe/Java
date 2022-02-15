package com.wiji.omikujiform.controllers;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmikujiFormController {
	
	@GetMapping("/omikuji")
	public String home() {		
		return "home.jsp";
	}
	
	@PostMapping("/submitForm")
	public String submit(HttpSession session,
		@RequestParam(value="number", defaultValue = "1") Integer number,
	    @RequestParam(value="city", defaultValue = "Seattle") String city,
	    @RequestParam(value="famousName", defaultValue = "Michael Jackson") String famousName,
	    @RequestParam(value="hobby", defaultValue = "dancing moonwalk") String hobby,
	    @RequestParam(value="somethingLiving", defaultValue = "aliens") String somethingLiving,
	    @RequestParam(value="quote", defaultValue = "you need to answer the form") String quote) {
	    		
	    	if(number != null && city != null && famousName !=null && hobby != null
	    	&& somethingLiving != null && quote != null) {
	    		
	    		session.setAttribute("number", number);
	    		session.setAttribute("city", city);
	    		session.setAttribute("famousName", famousName);
	    		session.setAttribute("hobby", hobby);
	    		session.setAttribute("somethingLiving", somethingLiving);
	    		session.setAttribute("quote", quote);

	    		return "redirect:/omikuji/show";
	    	}else {
	    		return "please complete the form";
	    	}
	    	
	   }
		
	
	@GetMapping("/omikuji/show")
	public String display() {
		
//		public String display(HttpSession session, Model model) {	
//		model.addAttribute("number", session.getAttribute("number"));
//		model.addAttribute("city", session.getAttribute("city"));
//		model.addAttribute("famousName", session.getAttribute("famousName"));
//		model.addAttribute("hobby", session.getAttribute("hobby"));
//		model.addAttribute("somethingLiving", session.getAttribute("somethingLiving"));
//		model.addAttribute("quote", session.getAttribute("quote"));	


		return "display.jsp";
	}
}
