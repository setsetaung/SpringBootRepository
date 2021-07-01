package com.example.librarysystem.repository;

import com.example.librarysystem.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher,Integer> {
    //no need to any code
}
