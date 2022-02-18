package com.wiji.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.wiji.dojosandninjas.models.Dojo;
import com.wiji.dojosandninjas.models.Ninja;
import com.wiji.dojosandninjas.services.MainService;

@Controller
public class HomeController {
	
	@Autowired
	private MainService mainService;
	
	@GetMapping("/dojos/new")
	public String dashboard( @ModelAttribute("dojo")Dojo dojo) {
		return "dashboard.jsp";
	}
	
	@PostMapping("/submitForm")
	public String post(@Valid @ModelAttribute("dojo")Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "dashboard.jsp";
		}else {
			Dojo newDojo = mainService.createDojo(dojo);
			return "redirect:/dojos/"+ newDojo.getId();
		}
	}
	
//	@GetMapping("/dojos")
//	public String dojos(@ModelAttribute("dojo")Dojo dojo, Model model) {
//		List<Dojo> dojos = mainService.allDojos();
//		model.addAttribute("dojos", dojos);
//		return "dojos.jsp";
//	}
	
	@GetMapping("/dojos/{id}")
	public String showOneDojo(@PathVariable("id")Long id, Model model) {
		Dojo dojo = mainService.findOneDojo(id);
		model.addAttribute("dojo", dojo);
		return "show.jsp";
	}
	
	@GetMapping("/ninjas/new")
	public String createNinjaForm(@ModelAttribute("ninja")Ninja ninja, Model model) {
		List<Dojo> dojos = mainService.allDojos();
		model.addAttribute("dojos", dojos);
		return "ninjaForm.jsp";
	}
	
	@PostMapping("/submitNinjaForm")
	public String post(@Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Dojo> dojos = mainService.allDojos();
			model.addAttribute("dojos", dojos);
			return "ninjaForm.jsp";
		}else {
			Ninja newNinja = mainService.createNinja(ninja);
			return "redirect:/dojos/"+ newNinja.getDojo().getId();
		}
	}
	
	
}
