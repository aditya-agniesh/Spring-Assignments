package com.example.spring_data_jpa_3.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "books")
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String bookName;

    // For Bidirectional OneToMany
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}