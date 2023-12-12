package com.kotbegemot.testtask2.repository.jpa;

import com.kotbegemot.testtask2.api.entity.Book;
import com.kotbegemot.testtask2.api.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReaderRepository extends JpaRepository<Reader, Long> {
}
