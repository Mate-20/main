package com.spring.service;

import java.util.List;

import com.spring.entities.Book;


public interface BookService {
    public List<Book> getBooks();
    public Book getBook(int id);
    public Book addBook(Book book);
    public void updateBook(int id, String bookName, String author);
    public void deleteBook(int id);
}
