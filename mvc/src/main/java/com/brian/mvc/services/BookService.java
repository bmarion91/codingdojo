package com.brian.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.brian.mvc.models.Book;
import com.brian.mvc.repositories.BookRepository;
//READ
@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	//returns all the items
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}
	//creation
	public Book createBook (Book b) {
		return bookRepository.save(b);
	}
	//retrieval
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		Book book = findBook(id);
		book.setTitle(title);
		book.setDescription(desc);
		book.setLanguage(lang);
		book.setNumberOfPages(numOfPages);
		return bookRepository.save(book);
	}
	public void deleteBook(Long id) {
		Book book = findBook(id);
		bookRepository.delete(book);
		
	}
}
