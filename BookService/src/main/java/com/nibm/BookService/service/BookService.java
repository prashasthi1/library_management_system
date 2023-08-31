/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nibm.BookService.service;

import com.nibm.BookService.Book;
import com.nibm.BookService.BookRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author natha
 */

@Service
public class BookService {
    
      @Autowired
    private BookRepository bookRepository;
      
     
   public  List<Book> getAllBooks(){
       List<Book> books=bookRepository.findAll();
       return books;
   }
      
 
    public Book getBookById(int id)
    {
        Optional<Book> book = bookRepository.findById(id);
        return book.get();
    }

  
   public void setAvailability(int id,String available){
        bookRepository.setAvailabilityByUserReferenceId(id,available);
   }
    public  Book createBook(Book book){
       return bookRepository.save(book);
   }
   
   public Book updateBook(Book book){
       return bookRepository.save(book);
   }
  
   public void deleteById(int id){
       bookRepository.deleteById(id);
   }
}
