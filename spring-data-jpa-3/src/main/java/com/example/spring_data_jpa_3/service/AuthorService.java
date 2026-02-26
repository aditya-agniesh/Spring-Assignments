package com.example.spring_data_jpa_3.service;

import com.example.spring_data_jpa_3.entity.Author;
import com.example.spring_data_jpa_3.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public Author saveAuthor(Author author) {

        // Set bidirectional relationship
        if (author.getBooks() != null) {
            author.getBooks().forEach(book -> book.setAuthor(author));
        }

        return authorRepository.save(author);
    }

    public Author getAuthorById(Long authorId) {
        return authorRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public void deleteAuthor(Long authorId) {
        authorRepository.deleteById(authorId);
    }
}