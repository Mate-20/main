package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.spring.entities.Author;
import com.spring.dao.BookDao;
import com.spring.entities.Book;


@Component
public class BookServiceImpl implements BookService {


    @Autowired
    private BookDao bookDao;

    @Autowired
    private AuthorServiceImpl authorServiceImpl;

    @Override
    public List<Book> getBooks() {
        return (List<Book>) bookDao.findAll();
    }

    @Override
    public Book getBook(int id) {
        Optional<Book> opt =  bookDao.findById(id);
        Book book = opt.get();
        return book;
    }

    @Override
    public Book addBook(Book book) {
        Author author = new Author();
        author.setName(book.getAuthor());
        authorServiceImpl.addAuthor(author);
        bookDao.save(book);
        return book;
    }

    @Override
    public void updateBook(int id, String bookName, String author) {
        Optional<Book> opt =  bookDao.findById(id);
        Book book = opt.get();
        book.setAuthor(author);
        book.setBookName(bookName);
        bookDao.save(book);
    }

    @Override
    public void deleteBook(int id) {
        Book book = getBook(id);
        bookDao.delete(book);
    }
    
}
