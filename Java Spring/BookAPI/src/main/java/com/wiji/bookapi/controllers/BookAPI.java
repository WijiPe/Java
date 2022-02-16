package com.wiji.bookapi.controllers;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wiji.bookapi.models.BookModel;
import com.wiji.bookapi.services.BookService;

@RestController
public class BookAPI {

	    private final BookService bookService;
	    public BookAPI(BookService bookService){
	        this.bookService = bookService;
	    }
	    
		@GetMapping("/api/books")
		public List<BookModel> index() {
			return bookService.allBooks();
		}
	    
	    @PostMapping("/api/icecreams")
		public BookModel createBook(
				@RequestParam("title")String title,
				@RequestParam("description")String desc,
				@RequestParam("language") String lang,
				@RequestParam("pages") Integer numOfPages
				
				) {
	    	
	    	BookModel book  = new BookModel(title, desc, lang, numOfPages);
			return bookService.createBook(book);
		}
	    // other methods removed for brevity
	    @PutMapping("/api/books/{id}")
	    public BookModel update(
	    		@PathVariable("id") Long id, 
	    		@RequestParam("title") String title, 
	    		@RequestParam("description") String desc, 
	    		@RequestParam("language") String lang,
	    		@RequestParam("pages") Integer numOfPages) {
	    	
	    	BookModel book = bookService.findBook(id);
	    	book.setTitle(title);
	    	book.setDescription(desc);
	    	book.setLanguage(lang);
	    	book.setNumberOfPages(numOfPages);
	        return bookService.updateBook(book);
	    }
	    
	    @GetMapping("/api/books/{id}")
		public BookModel show(@PathVariable("id") Long id) {
	    	BookModel book = bookService.findBook(id);
			return book;
		}
	    
	    @DeleteMapping("/api/books/{id}")
	    public void delete(@PathVariable("id") Long id) {
	        bookService.deleteBook(id);
	    }


}
