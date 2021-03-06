package com.example.librarysystem.model;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Integer id;

    @NotBlank(message = "Book Name Must Not Be Blank")
    @Column(name = "BOOK_NAME", nullable = false)
    private String book_name;

    @NotBlank(message = "Book Subname Must Not Be Blank")
    @Column(name = "BOOK_SUBNAME")
    String book_subname;

    @NotBlank(message = "Book Setial Name Must Not Be Blank")
    @Column(name = "SERIAL_NAME")
    String serial_name;

    @Column(name = "DESCRIPTION")
    String description;

    @NotBlank(message = "Book ISBN Must Not Be Blank")
    @Column(name = "ISBN")
    String isbn;
    
    @NotNull(message = "Quantity Must Not Be Blank")
    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;


    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "AUTHOR_ID")
    Author author;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_subname() {
        return book_subname;
    }

    public void setBook_subname(String book_subname) {
        this.book_subname = book_subname;
    }

    public String getSerial_name() {
        return serial_name;
    }

    public void setSerial_name(String serial_name) {
        this.serial_name = serial_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    
}

