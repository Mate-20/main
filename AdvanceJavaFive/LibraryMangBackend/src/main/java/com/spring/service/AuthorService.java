package com.spring.service;

import java.util.*;

import com.spring.entities.Author;


public interface AuthorService{ 
    public List<Author> getAuthors();
    public Author getAuthor(int id);
    public void addAuthor(Author author);
    public void updateAuthor(int id, String name);
    public void deleteAuthor(int id);
}
