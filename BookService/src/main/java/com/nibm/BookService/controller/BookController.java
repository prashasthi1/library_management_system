/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nibm.BookService.controller;

import com.nibm.BookService.Book;
import com.nibm.BookService.BookRepository;
import com.nibm.BookService.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sahan
 */

@RestController
public class BookController {
    
    @Autowired
    private BookService bookService; 
    
    @CrossOrigin(origins = "*")     
    @GetMapping(path = "/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/books/{id}")
    public Book getBookById(@PathVariable int id){
        return bookService.getBookById(id);
    }
   
    @CrossOrigin(origins = "*")
    @PutMapping(path = "/books/{id}/{available}")
    public void setAvailability(@PathVariable int id,@PathVariable String available){
        bookService.setAvailability(id,available);
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/books")
    public Book createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }
    
    @CrossOrigin(origins = "*")
    @PutMapping(path = "/books/{id}")
    public void updateBook(@PathVariable int id, @RequestBody Book book){
        book.setId(id);
        bookService.updateBook(book);
    }
    
    @CrossOrigin(origins = "*")
    @DeleteMapping("books/{id}")
    public void deleteBook(@PathVariable int id) {
        bookService.deleteById(id);
    }
    
    
}

