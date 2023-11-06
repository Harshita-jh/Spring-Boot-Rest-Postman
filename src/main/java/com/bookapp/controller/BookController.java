package com.bookapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.entity.Book;
import com.bookapp.service.BookService;

@RestController
@RequestMapping("book-restapi")
public class BookController {
	
	@Autowired
	BookService bookService;

	// http://localhost:8080/book-restapi/hello
	@GetMapping("/hello")
	public String sayHello() {
		return "Welcome to RestAPI";
	}
	
	// http://localhost:8080/book-restapi/book-by-id/10
	@GetMapping("/book-by-id/{bookid}")
	public Book getBookById(@PathVariable int bookid) {
		return bookService.getById(bookid);
	}
	
	// http://localhost:8080/book-restapi/books-by-author/kathy
	@GetMapping("/books-by-author/{author}")
	public List<Book> getBookByAuthor(String author) {
		return bookService.getBooksByAuthor(author);
	}
	
	// http://localhost:8080/book-restapi/books-by-category/?category=Fiction
	@GetMapping("/books-by-category")
	public List<Book> getBookByCategory(@RequestParam String category) {
		return bookService.getBooksByCategory(category);
	}
}
