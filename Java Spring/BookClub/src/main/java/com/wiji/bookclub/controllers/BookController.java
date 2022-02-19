package com.wiji.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.wiji.bookclub.models.Book;
import com.wiji.bookclub.models.User;
import com.wiji.bookclub.services.BookService;
import com.wiji.bookclub.services.UserService;

@Controller
public class BookController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books/new")
	public String bookForm(HttpSession session, @ModelAttribute("book")Book book) {
		if(session.getAttribute("userId")==null) {
    		return "redirect:/";
    	}
		return "bookForm.jsp";
	}
	
	@PostMapping("/submitForm")
	public String submitForm(@Valid @ModelAttribute("book")Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "bookForm.jsp";
		}else {
			bookService.createBook(book);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/books/{id}")
	public String bookDetails(@PathVariable("id")Long id, HttpSession session, Model model) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		Book bookDetail = bookService.oneBook(id);
    	model.addAttribute("book", bookDetail);
    	User user = userService.findOneUser((Long)session.getAttribute("userId"));
    	model.addAttribute("user", user);
    	return "bookDetails.jsp";
	}

}

