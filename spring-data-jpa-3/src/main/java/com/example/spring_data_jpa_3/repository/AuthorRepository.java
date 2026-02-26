package com.example.spring_data_jpa_3.repository;

import com.example.spring_data_jpa_3.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
}
