package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.dao.LoginDao;
import com.spring.entities.Login;

@Component
public class LoginService {
    
    @Autowired
    private LoginDao loginDao;

    public boolean check(String user, String pass){
        List<Login> list = (List<Login>) loginDao.findAll();
        for(Login l : list){
            if(l.getPassword().equals(pass) && l.getUsername().equals(user)) {
				return true;
			}
        }return false;
    }

    public void add(Login login){
        loginDao.save(login);
    }
}
