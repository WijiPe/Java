package com.wiji.bookapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wiji.bookapi.models.BookModel;
import com.wiji.bookapi.repository.BookRepository;


@Service
public class BookService {
 // adding the book repository as a dependency
	private final BookRepository bookRepository;
 
 public BookService(BookRepository bookRepository) {
     this.bookRepository = bookRepository;
 }
 // returns all the books
 public List<BookModel> allBooks() {
     return bookRepository.findAll();
 }
 // creates a book
 public BookModel createBook(BookModel b) {
     return bookRepository.save(b);
 }
 // retrieves a book
 public  BookModel findBook(Long id) {
     Optional<BookModel> optionalBook = bookRepository.findById(id);
     if(optionalBook.isPresent()) {
         return optionalBook.get();
     } else {
         return null;
     }
 }
 
 public  BookModel updateBook(BookModel b) {
 	return bookRepository.save(b);
 }
 
 public void deleteBook(Long id) {
	bookRepository.deleteById(id);
}

}
