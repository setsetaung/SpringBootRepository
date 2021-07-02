package com.example.librarysystem.model;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NotBlank(message = "Publisher Name Must Not Be Blank")
    @Column(name = "PUBLISHER_NAME")
    String publisher_name;
    @Column(name = "DESCRIPTION")
    String description;
}
