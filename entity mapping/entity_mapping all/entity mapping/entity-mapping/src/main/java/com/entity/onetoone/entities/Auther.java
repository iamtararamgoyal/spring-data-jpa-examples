package com.entity.onetoone.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "authers")
public class Auther {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fname;
    private String lname;
    private String language;
    @OneToOne(mappedBy = "auther")
    @JsonBackReference
    private Book book;

    public Auther() {

    }

    public Auther(int id, String fname, String lname, String language, Book book) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.language = language;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Auther{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", language='" + language + '\'' +
                ", book=" + book +
                '}';
    }
}
