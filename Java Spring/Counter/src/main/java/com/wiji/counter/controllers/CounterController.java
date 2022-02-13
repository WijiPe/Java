package com.wiji.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CounterController {
	@GetMapping("/your_server")
	public String home(HttpSession session) {
		if(session.getAttribute("count")==null) {
			session.setAttribute("count", 0);
		}else {
			Integer tempCount = (Integer) session.getAttribute("count");
			session.setAttribute("count", tempCount+1);
		}
		return "index.jsp";
	}
	
	@GetMapping("your_server/counter")
	public String count() {		
		return "counter.jsp";
	}
	
	@GetMapping("your_server/counter/counter2")
	public String count2(HttpSession session) {
		if(session.getAttribute("count2")==null) {
			session.setAttribute("count2", 0);
		}else {
			Integer tempCount = (Integer) session.getAttribute("count2");
			session.setAttribute("count2", tempCount+2);
		}
		return "count2.jsp";
	}
	
	@GetMapping("your_server/counter/reset")
	public String reset(HttpSession session) {
		session.setAttribute("count2", 0);
		session.setAttribute("count", 0);
			
		return "redirect:/your_server/counter";
	}
}
