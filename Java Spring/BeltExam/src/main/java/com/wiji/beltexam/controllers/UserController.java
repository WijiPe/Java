package com.wiji.beltexam.controllers;


import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.wiji.beltexam.models.LoginUser;
import com.wiji.beltexam.models.Show;
import com.wiji.beltexam.models.User;
import com.wiji.beltexam.services.RatingService;
import com.wiji.beltexam.services.ShowService;
import com.wiji.beltexam.services.UserService;



@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ShowService showService;
	
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}
	
	 @PostMapping("/register")
	    public String register(@Valid @ModelAttribute("newUser") User newUser, 
	            BindingResult result, Model model, HttpSession session) {
	        
	    	userService.register(newUser, result);

	        if(result.hasErrors()) {
	            model.addAttribute("newLogin", new LoginUser());
	            return "index.jsp";
	        }else { 
	        	session.setAttribute("userId", newUser.getId());
	        	return "redirect:/dashboard";
	        }
	    }
	    
	    
	    @PostMapping("/login")
	    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	            BindingResult result, Model model, HttpSession session) {
	        
	        // Add once service is implemented:
	         User user = userService.login(newLogin, result);
	    
	        if(result.hasErrors()) {
	            model.addAttribute("newUser", new User());
	            return "index.jsp";
	        }
	    
	    	session.setAttribute("userId", user.getId());
	    	return "redirect:/dashboard";
	    }
	    
	    @GetMapping("/dashboard")
	    public String dashboard(HttpSession session, Model model) {
	    	if(session.getAttribute("userId")==null) {
	    		return "redirect:/";
	    	}
	    	User user = userService.findOneUser((Long)session.getAttribute("userId"));
	    	model.addAttribute("user", user);
	    	List<Show> shows = showService.allShows();
	    	model.addAttribute("shows", shows);
	    	
	    	return "dashboard.jsp";
	    }
	    
	    @GetMapping("/logout")
	    public String logout(HttpSession session) {
	    	session.invalidate();
	    	return "redirect:/";
	    }

}
