package com.wiji.projectmanager.controllers;

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

import com.wiji.projectmanager.models.LoginUser;
import com.wiji.projectmanager.models.Project;
import com.wiji.projectmanager.models.User;
import com.wiji.projectmanager.services.ProjectService;
import com.wiji.projectmanager.services.UserService;



@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProjectService projectService;
	

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "loginForm.jsp";
	}
	
	 @PostMapping("/register")
	    public String register(@Valid @ModelAttribute("newUser") User newUser, 
	            BindingResult result, Model model, HttpSession session) {
	        
	    	userService.register(newUser, result);

	        if(result.hasErrors()) {
	            model.addAttribute("newLogin", new LoginUser());
	            return "loginForm.jsp";
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
	            return "loginForm.jsp";
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
	    	List<Project> notYourProjects = projectService.findByUsersNotContains(user);
	    	List<Project> yourProjects = projectService.findByUsersContaining(user);
	    	model.addAttribute("notYourProjects", notYourProjects);
	    	model.addAttribute("yourProjects", yourProjects);
	    	model.addAttribute("user", user);
	    	
	    	return "dashboard.jsp";
	    }
	    
	    @GetMapping("/logout")
	    public String logout(HttpSession session) {
	    	session.invalidate();
	    	return "redirect:/";
	    }


}
