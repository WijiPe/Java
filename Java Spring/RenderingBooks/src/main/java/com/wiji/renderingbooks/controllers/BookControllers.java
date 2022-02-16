package com.wiji.renderingbooks.controllers;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wiji.renderingbooks.models.Book;
import com.wiji.renderingbooks.services.BookService;

@Controller
public class BookControllers {
	@Autowired
	private BookService bookService;
	
//	@GetMapping("/books")
//	public String dashboard(Model model) {
//		List<Book> books = bookService.allBooks();
//		model.addAttribute("books", books);
//		return "dashboard.jsp";
//	}
	
	@GetMapping("/books/{id}")
	public String showOneIcecream(@PathVariable("id")Long id, Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "show.jsp";
	}
}
