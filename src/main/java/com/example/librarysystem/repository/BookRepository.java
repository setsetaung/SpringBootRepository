package com.example.librarysystem.repository;

import com.example.librarysystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    @Query("Select b from Book b where b.book_name LIKE %?1%"
            + "OR b.isbn LIKE %?1%"
            + "OR b.serial_name LIKE %?1%"
            + "OR b.book_subname LIKE %?1%"
            + "OR b.author.author_name LIKE %?1%"
            + "OR b.publisher.publisher_name LIKE %?1%"
            )
    List<Book> findByName(String keyword);
}
