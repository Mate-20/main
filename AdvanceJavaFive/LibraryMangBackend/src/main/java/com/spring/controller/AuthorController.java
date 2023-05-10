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

import com.spring.entities.Author;
import com.spring.service.AuthorServiceImpl;

@RestController
public class AuthorController {
    
    @Autowired
    private AuthorServiceImpl authorServiceImpl;

    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAuthors(){

        List<Author> list = authorServiceImpl.getAuthors();
        if(list.size() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // We will get the status code of 404 if the list will be empty
        }
        return ResponseEntity.of(Optional.of(list));
    }

    @GetMapping("/authors/{id}")
    public Author getAuthor(@PathVariable("id") int id){
        return authorServiceImpl.getAuthor(id);
    }

    @PostMapping("/authors")
    public Author addAuthor(@RequestBody Author author){
        authorServiceImpl.addAuthor(author);
        return author; 
    }

    @DeleteMapping("/authors/{id}")
    public Author deleteAuthor(@PathVariable int id){
        Author author = authorServiceImpl.getAuthor(id);
        authorServiceImpl.deleteAuthor(id);
        return author;
    }

    @PutMapping("/authors")
    public Author updateAuthor(@RequestBody Author author){
        authorServiceImpl.updateAuthor(author.getId(),author.getName());
        return authorServiceImpl.getAuthor(author.getId());
    }
}
