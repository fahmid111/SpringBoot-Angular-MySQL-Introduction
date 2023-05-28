package com.fahmid.springboot_angular_mysql_intro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fahmid.springboot_angular_mysql_intro.model.Book;
import com.fahmid.springboot_angular_mysql_intro.service.BookService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")


public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/books")
    public List<Book> addNewBook(@RequestBody List<Book> newBooks) {
        return bookService.addNewBook(newBooks);
    }

    @GetMapping("/books/search/title")
    public List<Book> findBookByTitle(@RequestParam("title") String title) {
        return bookService.findBookByTitle(title);
    }
    
    @GetMapping("/books/search/{id}")
    public Book findBookByID(@PathVariable Long id) {
        return bookService.findBookByID(id);
    }

    @PostMapping("/books/search/{id}")
    public Book updateBookByID(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBookByID(id, book);
    }

    @DeleteMapping("/books/search/{id}")
    public void deleteBookByID(@PathVariable Long id) {
        bookService.deleteBookByID(id);
    }
}