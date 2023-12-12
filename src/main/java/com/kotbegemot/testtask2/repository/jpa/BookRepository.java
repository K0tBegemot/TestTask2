package com.kotbegemot.testtask2.repository.jpa;

import com.kotbegemot.testtask2.api.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    public Optional<Book> findByIsbn(String isbn);
}