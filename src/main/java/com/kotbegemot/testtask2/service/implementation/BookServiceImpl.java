package com.kotbegemot.testtask2.service.implementation;

import com.kotbegemot.testtask2.api.dto.book.BookDTO;
import com.kotbegemot.testtask2.api.entity.Book;
import com.kotbegemot.testtask2.api.mapper.BookMapper;
import com.kotbegemot.testtask2.repository.jpa.BookRepository;
import com.kotbegemot.testtask2.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl extends EntityServiceImpl<BookDTO, Book, BookRepository, BookMapper> implements BookService{
    public BookServiceImpl(BookRepository bookRepository1, BookMapper bookMapper1)
    {
        super(bookRepository1, bookMapper1);
    }
}
