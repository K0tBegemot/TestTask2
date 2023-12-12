package com.kotbegemot.testtask2.service;

import com.kotbegemot.testtask2.api.dto.Paged;
import com.kotbegemot.testtask2.api.dto.book.BookDTO;
import com.kotbegemot.testtask2.api.entity.Book;
import com.kotbegemot.testtask2.api.mapper.BookMapper;
import com.kotbegemot.testtask2.repository.jpa.BookRepository;

public interface BookService extends EntityService<BookDTO, Book, BookRepository, BookMapper>{
}
