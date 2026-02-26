package com.example.spring_data_jpa_3.controller;

import com.example.spring_data_jpa_3.entity.Author;
import com.example.spring_data_jpa_3.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorService.saveAuthor(author);
    }

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @DeleteMapping("/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return "Author deleted successfully";
    }
}