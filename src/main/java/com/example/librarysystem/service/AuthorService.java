package com.example.librarysystem.service;

import com.example.librarysystem.model.Author;
import com.example.librarysystem.model.Book;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    public List<Author> findAll();

    public Author findById(int theId);


    public void save(Author theAuthor);

    public void deleteById(int theId);

    public void addBook(Author author, Book book);

    Optional<Author> getAuthor(Integer authorId);
}
