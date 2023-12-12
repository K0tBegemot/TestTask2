package com.kotbegemot.testtask2.api.mapper;

import com.kotbegemot.testtask2.api.dto.book.BookDTO;
import com.kotbegemot.testtask2.api.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class BookMapper implements EntityMapper<Book, BookDTO>{
    public abstract Book dtoToEntity(BookDTO bookDTO);
    public abstract BookDTO entityToDTO(Book book);
    public abstract List<BookDTO> entityListToDTO(List<Book> bookList);
}
