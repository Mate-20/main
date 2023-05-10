package com.spring.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entities.Book;
import com.spring.service.BookServiceImpl;


@RestController
public class BookController {
    
    @Autowired
    private BookServiceImpl bookServiceImpl;

    @PostMapping("/books")
    public ResponseEntity<Book> addAuthor(@RequestBody Book book){
        Book b = null;
        try{
            b = this.bookServiceImpl.addBook(book);
            bookServiceImpl.addBook(book);
            return ResponseEntity.of(Optional.of(b));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }    
    }

    @GetMapping("/books")
    public List<Book> getBooks(){
        List<Book> list = bookServiceImpl.getBooks();
        return list;
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id){
        return bookServiceImpl.getBook(id);
    }

    @DeleteMapping("/books/{id}")
    public Book deleteBook(@PathVariable("id") int id){
        Book book = bookServiceImpl.getBook(id);
        bookServiceImpl.deleteBook(id);
        return book;
    }

    @PutMapping("/books")
    public Book updateBook(@RequestBody Book book){
        String bookName = book.getBookName();
        String author = book.getAuthor();
        bookServiceImpl.updateBook(book.getBookCode(), bookName, author);
        return book;
    }


}