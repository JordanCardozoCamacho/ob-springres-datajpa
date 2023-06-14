package com.jordan.obspringresdatajpa.Entities;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
public class Book {

    //Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private Integer pages;
    private Double price;
    private LocalDate releaseDate;
    private Boolean onLine;


    //Constructors

    public Book(){

    }

    public Book(Long id, String title, String author, Integer pages, Double price, LocalDate releaseDate, Boolean onLine) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
        this.releaseDate = releaseDate;
        this.onLine = onLine;
    }

    //Methods (Getters y Setters)
    public void setId(Long id){
        this.id = id;

    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;

    }

    public void setPages(Integer pages){
        this.pages = pages;
    }

    public void setPrice(Double price){
        this.price = price;

    }

    public void setReleaseDate(LocalDate releaseDate){
        this.releaseDate = releaseDate;

    }

    public void setOnLine(Boolean onLine){
        this.onLine = onLine;

    }

    public Long getId(){
        return  this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public Integer getPages(){
        return this.pages;
    }

    public Double getPrice(){
        return this.price;
    }

    public LocalDate getReleaseDate(){
        return this.releaseDate;
    }

    public Boolean getOnLine(){
        return this.onLine;
    }

    //to String


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", Título='" + title + '\'' +
                ", Autor='" + author + '\'' +
                ", Página=" + pages +
                ", Precio=" + price +
                ", Fecha de Lanzamiento=" + releaseDate +
                ", Disponible=" + onLine +
                '}';
    }
}
