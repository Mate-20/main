package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.dao.AuthorDao;
import com.spring.entities.Author;



@Component
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorDao;

    @Override
    public List<Author> getAuthors() {
        return (List<Author>) authorDao.findAll();
    }

    @Override
    public Author getAuthor(int id) {
        Optional<Author> opt =  authorDao.findById(id);
        Author auth = opt.get();
        return auth;
    }

    @Override
    public void addAuthor(Author author) {
        Boolean check = false;
        List<Author> list = getAuthors();
        for(Author auth : list){
            if(auth.getName().equals(author.getName()) ){
                System.out.println("Author already present");
                check = true;
                break;
            }
        }
        if(check == false){
            authorDao.save(author);
        }
        
    }

    @Override
    public void updateAuthor(int id, String name) {
        Optional<Author> opt =  authorDao.findById(id);
        Author auth = opt.get();
        auth.setName(name);
        authorDao.save(auth);
    }

    @Override
    public void deleteAuthor(int id) {
        Author auth = getAuthor(id);
        authorDao.delete(auth);
    }
    
}
