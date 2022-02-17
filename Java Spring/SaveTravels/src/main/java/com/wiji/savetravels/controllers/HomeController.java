package com.wiji.savetravels.controllers;


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

import com.wiji.savetravels.models.Expense;
import com.wiji.savetravels.services.ExpenseService;

@Controller
public class HomeController {

		@Autowired
		private ExpenseService expenseService;

	
		@GetMapping("/expenses")
		public String dashboard(@ModelAttribute("expenseModel") Expense expenseModel, Model model) {
			List<Expense> e = expenseService.allExpenses();
			model.addAttribute("expenses", e);
			return "index.jsp";
		}
		
		@PostMapping("/submitForm")
		public String post(@Valid @ModelAttribute("expenseModel")Expense expenseModel, BindingResult result, Model model) {
			if(result.hasErrors()) {
				List<Expense> expenses = expenseService.allExpenses();
				model.addAttribute("expenses", expenses);
				return "index.jsp";
			}else {
				expenseService.createExpense(expenseModel);
				return "redirect:/expenses";
			}
		}
		
		@GetMapping("/expenses/edit/{id}")
		public String editForm(@PathVariable("id")Long id, Model model) {
			Expense e = expenseService.findExpense(id);
			model.addAttribute("expenseModel", e);
			return "edit.jsp";
		}
		
		@PutMapping("/expenses/edit/{id}")
		public String edit(@Valid @ModelAttribute("expenseModel")Expense expenseModel, BindingResult result) {
			if(result.hasErrors()) {
				return "edit.jsp";
			}else {
				expenseService.updateExpense(expenseModel);
				return "redirect:/expenses";
			}
		}
		
		@DeleteMapping("/expenses/delete/{id}")
		public String delete(@PathVariable("id")Long id) {
			expenseService.deleteExpense(id);
			return "redirect:/expenses";
		}
}
