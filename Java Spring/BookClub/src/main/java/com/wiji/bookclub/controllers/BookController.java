package com.wiji.bookclub.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/books/edit/{id}")
	public String editForm(@PathVariable("id")Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		Book book = bookService.oneBook(id);
		model.addAttribute("book", book);
		return "edit.jsp";
	}
	
	@PutMapping("/books/edit/{id}")
	public String edit(@PathVariable("id")Long id, @Valid @ModelAttribute("book")Book book, BindingResult result,  HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
			bookService.updateBook(book);
			return "redirect:/books/"+id;
		}
	}
	
    @GetMapping("/lender_dashboard")
    public String dashboard(HttpSession session, Model model) {
    	if(session.getAttribute("userId")==null) {
    		return "redirect:/";
    	}
    	List<Book> books = bookService.findBooksByBorrower();
    	List<Book> bookNotBorrows = bookService.findBooksByNotBorrower();
    	User user = userService.findOneUser((Long)session.getAttribute("userId"));
    	model.addAttribute("books", books);
    	model.addAttribute("bookNotBorrows", bookNotBorrows);
    	model.addAttribute("user", user);
    	
    	return "borrow-book.jsp";
    }
    
	@GetMapping("/books/borrow/{id}")
	public String borrowBook(@PathVariable("id")Long id, Model model, HttpSession session) {
    	if(session.getAttribute("userId")==null) {
    		return "redirect:/";
    	}
		User user = userService.findOneUser((Long) session.getAttribute("userId"));
		Book updateBook = bookService.oneBook(id);
		updateBook.setBorrower(user);
		bookService.updateBook(updateBook);
		
		return "redirect:/lender_dashboard";

	}
	
	@GetMapping("/books/return/{id}")
	public String returnBook(@PathVariable("id")Long id, Model model, HttpSession session) {
    	if(session.getAttribute("userId")==null) {
    		return "redirect:/";
    	}
		Book updateBook = bookService.oneBook(id);
		updateBook.setBorrower(null);
		bookService.updateBook(updateBook);
		
		return "redirect:/lender_dashboard";

	}
	
	@DeleteMapping("/books/delete/{id}")
	public String deleteBook(@PathVariable("id")Long id, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		bookService.deleteBook(id);
		return "redirect:/lender_dashboard";
	}
}

