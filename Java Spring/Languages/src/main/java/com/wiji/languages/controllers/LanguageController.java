package com.wiji.languages.controllers;

import java.util.List;

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

import com.wiji.languages.models.Language;
import com.wiji.languages.services.LanguageService;




@Controller
public class LanguageController {

	@Autowired
	private LanguageService languageService;
	
	@GetMapping("/languages")
	public String dashboard(@ModelAttribute("language") Language language, Model model) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		return "dashboard.jsp";

	}
	
	@PostMapping("/submitForm")
	public String post(@Valid @ModelAttribute("language")Language language, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Language> languages = languageService.allLanguages();
			model.addAttribute("languages", languages);
			return "dashboard.jsp";
		}else {
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@GetMapping("/lanuages/{id}")
	public String showOneLanguage(@PathVariable("id")Long id, Model model) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "details.jsp";
	}
	
	@GetMapping("/lanuages/edit/{id}")
	public String editForm(@PathVariable("id")Long id, Model model) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "edit.jsp";
	}
	
	@PutMapping("/languages/edit/{id}")
	public String edit(@Valid @ModelAttribute("Language")Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
			languageService.updateLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@DeleteMapping("/languages/delete/{id}")
	public String delete(@PathVariable("id")Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}
}
