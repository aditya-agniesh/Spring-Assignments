package com.example.spring_data_jpa_3.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "authors")
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;

    private String authorName;

    @Embedded
    private Address address;

    @ElementCollection
    @CollectionTable(
            name = "author_subjects",
            joinColumns = @JoinColumn(name = "author_id")
    )
    @Column(name = "subject")
    private List<String> subjects;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_book_id")
    private Book profileBook;

    @OneToMany(mappedBy = "author",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Book> books;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "author_book_mapping",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> collaborativeBooks;
}