package com.example.librarysystem.model;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "PUBLISHER")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Integer id;
    @Column(name = "PUBLISHER_NAME")
    String publisher_name;
    @Column(name = "DESCRIPTION")
    String description;
}
