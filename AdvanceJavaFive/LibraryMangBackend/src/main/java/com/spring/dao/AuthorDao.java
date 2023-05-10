package com.spring.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.entities.Author;

@Repository
public interface AuthorDao extends CrudRepository<Author,Integer>{
    
}
