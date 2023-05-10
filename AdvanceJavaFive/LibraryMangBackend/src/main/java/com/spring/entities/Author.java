package com.spring.entities;


@javax.persistence.Entity
public class Author {
    
    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
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
