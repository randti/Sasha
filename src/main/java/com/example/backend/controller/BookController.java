package com.example.backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.entity.Book;
import com.example.backend.repository.BookRepository;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3030")
@RestController
@RequestMapping("/api")
public class BookController {
	
	private Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("/books")
	public List<Book> getBooks(){
		return bookRepository.findAll();
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Object> getBookById(@PathVariable("id") Long id) {
		try {
			Book book = bookRepository.findById(id).get();
			if(book != null) {
				return new ResponseEntity<Object>(book, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch(Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/books")
	public ResponseEntity<Object> createBook(@RequestBody Book book) {
		try {
			Book savedBook = bookRepository.save(book);
			return new ResponseEntity<Object>(savedBook, HttpStatus.OK);
		} catch(Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/books/{id}")
	public ResponseEntity<Object> updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
		try {
			book.setId(id);
			Book savedBook = bookRepository.save(book);
			return new ResponseEntity<Object>(savedBook, HttpStatus.OK);
		} catch(Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/Books/{id}")
	public ResponseEntity<HttpStatus> deleteBook(@PathVariable("id") Long id) {
		try {
			bookRepository.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} catch(Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
