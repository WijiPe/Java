package com.wiji.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiji.bookclub.models.Book;
import com.wiji.bookclub.repository.BookRepository;


@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> allBooks(){
		return bookRepository.findAll();
	}
	
	public Book oneBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}else {
			return null;
		}
	}

	public Book createBook(Book book) {
		return bookRepository.save(book);
	}
		
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}
		
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
	
	public List<Book> findBooksByBorrower(){
		return bookRepository.findByBorrowerNull();
	}
	
	public List<Book> findBooksByNotBorrower(){
		return bookRepository.findByBorrowerNotNull();
	}
	
}
