package com.spring.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.entities.Login;


public interface LoginDao extends CrudRepository<Login,Integer> {
    
}
