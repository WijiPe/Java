package com.wiji.renderingbooks.controllers;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wiji.renderingbooks.models.Book;
import com.wiji.renderingbooks.services.BookService;

@RestController
public class BookAPI {

	    private final BookService bookService;
	    public BookAPI(BookService bookService){
	        this.bookService = bookService;
	    }
	    
		@GetMapping("/api/books")
		public List<Book> index() {
			return bookService.allBooks();
		}
	    
	    @PostMapping("/api/books")
		public Book createBook(
				@RequestParam("title")String title,
				@RequestParam("description")String description,
				@RequestParam("language") String language,
				@RequestParam("numberOfPages") Integer numberOfPages
				
				) {
	    	
	    	Book book  = new Book(title, description, language, numberOfPages);
			return bookService.createBook(book);
		}
	    // other methods removed for brevity
	    @PutMapping("/api/books/{id}")
	    public Book update(
	    		@PathVariable("id") Long id, 
	    		@RequestParam("title") String title, 
	    		@RequestParam("description") String description, 
	    		@RequestParam("language") String language,
	    		@RequestParam("numberOfPages") Integer numberOfPages) {
	    	
	    	Book book = bookService.findBook(id);
	    	book.setTitle(title);
	    	book.setDescription(description);
	    	book.setLanguage(language);
	    	book.setNumberOfPages(numberOfPages);
	        return bookService.updateBook(book);
	    }
	    
	    @GetMapping("/api/books/{id}")
		public Book show(@PathVariable("id") Long id) {
	    	Book book = bookService.findBook(id);
			return book;
		}
	    
	    @DeleteMapping("/api/books/{id}")
	    public void delete(@PathVariable("id") Long id) {
	        bookService.deleteBook(id);
	    }
}
