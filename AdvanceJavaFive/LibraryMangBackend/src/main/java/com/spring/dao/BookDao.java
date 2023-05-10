package com.spring.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.entities.Book;


@Repository
public interface BookDao extends CrudRepository<Book,Integer>{
    
}
