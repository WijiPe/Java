package com.wiji.beltexam.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.wiji.beltexam.models.Rating;
import com.wiji.beltexam.models.Show;
import com.wiji.beltexam.models.User;
import com.wiji.beltexam.services.RatingService;
import com.wiji.beltexam.services.ShowService;
import com.wiji.beltexam.services.UserService;




@Controller
public class HomeController {
	
	@Autowired
	private ShowService showService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RatingService ratingService;
	
    @GetMapping("/show/new")
    public String showForm( @ModelAttribute("show")Show show, HttpSession session) {
    	if(session.getAttribute("userId")==null) {
    		return "redirect:/";
    	}
    	return "form.jsp";
    }
    
    @PostMapping("/submitShowForm")
	public String submitForm(@Valid @ModelAttribute("show")Show show, BindingResult result, HttpSession session) {
//    	if(session.getAttribute("userId")==null) {
//    		return "redirect:/";
//    	}
    	
    	showService.createShow2(show, result);
    	
		if(result.hasErrors()) {
//			model.addAttribute("show", show);
			return "form.jsp";
		}else {
			showService.createShow(show);
			return "redirect:/dashboard";
		}
	}
    
    @GetMapping("/show/details/{id}")
	public String edit(@PathVariable("id")Long id, HttpSession session, Model model, @ModelAttribute("rating")Rating rating) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		Show show = showService.oneShow(id);
		model.addAttribute("show", show);
		List<Rating> ratings = ratingService.findByShow_idOrderByRateDesc(id);
		model.addAttribute("ratings", ratings);
		return "details.jsp";
	}
    
    @GetMapping("/show/edit/{id}")
	public String editForm(@PathVariable("id")Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		

		Show show = showService.oneShow(id);
		model.addAttribute("show", show);
		List<Rating> ratings = ratingService.allRatings();
		model.addAttribute("ratings", ratings);
		return "edit.jsp";
	}
	
	@PutMapping("/show/edit/{id}")
	public String edit(@PathVariable("id")Long id, @Valid @ModelAttribute("show")Show show, BindingResult result,  HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		
		showService.createShow2(show, result);
		
		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
			showService.updateShow(show);
			return "redirect:/dashboard";
		}
	}
	
	@DeleteMapping("/show/delete/{id}")
	public String deleteBook(@PathVariable("id")Long id, HttpSession session) {
//		if(session.getAttribute("userId")==null) {
//			return "redirect:/";
//		}
		showService.deleteShow(id);
		return "redirect:/dashboard";
	}
	
    @PostMapping("/submitRatingForm/{showid}")
	public String submitRatingForm(@PathVariable("showid")Long id, @Valid @ModelAttribute("rating")Rating rating, 
			BindingResult result, HttpSession session, Model model) {
    	
    	Show show = showService.oneShow(id);
    	
		if(result.hasErrors()) {
			model.addAttribute("show", show);
			List<Rating> ratings = ratingService.findByShow_idOrderByRateDesc(id);
			model.addAttribute("ratings", ratings);
			return "details.jsp";
		}else {

			ratingService.createRating(rating);
			showService.updateShow(show);

			return "redirect:/show/details/"+id;
		}
	}
}
