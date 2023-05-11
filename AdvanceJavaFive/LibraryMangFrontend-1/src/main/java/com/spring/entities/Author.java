package com.spring.entities;

import lombok.Data;

@Data
public class Author {
    
    private int id;

    private String name;

    public Author(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Author() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
