package com.kotbegemot.testtask2.api.mapper;

import com.kotbegemot.testtask2.api.dto.book.BookDTO;
import com.kotbegemot.testtask2.api.dto.library.LibraryRecordDTO;
import com.kotbegemot.testtask2.api.entity.Book;
import com.kotbegemot.testtask2.api.entity.LibraryRecord;
import com.kotbegemot.testtask2.service.implementation.BookServiceImpl;
import com.kotbegemot.testtask2.service.implementation.ReaderServiceImpl;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class LibraryMapper implements EntityMapper<LibraryRecord, LibraryRecordDTO> {
    protected ReaderServiceImpl readerService;
    protected BookServiceImpl bookService;
    @Mapping(target = "book", expression = "java( dto.getBook())")
    @Mapping(target = "reader", expression = "java( dto.getReader())")
    @Mapping(target = "pickupTime", expression = "java( java.time.LocalDateTime.now())")
    public abstract LibraryRecord dtoToEntity(LibraryRecordDTO dto);
    @Mapping(target = "bookId", expression = "java( record.getBook().getId())")
    @Mapping(target = "readerId", expression = "java( record.getReader().getId())")
//    @Mapping(target = "reader", constant = "null")
//    @Mapping(target = "book", constant = "null")
    @Mapping(target = "pickupTime", source = "pickupTime")
    public abstract LibraryRecordDTO entityToDTO(LibraryRecord record);
    public abstract List<LibraryRecordDTO> entityListToDTO(List<LibraryRecord> bookList);
}
