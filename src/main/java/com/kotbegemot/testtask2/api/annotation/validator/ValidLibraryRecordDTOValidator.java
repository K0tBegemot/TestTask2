package com.kotbegemot.testtask2.api.annotation.validator;

import com.kotbegemot.testtask2.api.annotation.ValidDate;
import com.kotbegemot.testtask2.api.annotation.ValidLibraryRecordDTO;
import com.kotbegemot.testtask2.api.dto.library.LibraryRecordDTO;
import com.kotbegemot.testtask2.api.entity.Reader;
import com.kotbegemot.testtask2.repository.jpa.BookRepository;
import com.kotbegemot.testtask2.repository.jpa.ReaderRepository;
import com.kotbegemot.testtask2.service.exception.EntityNotFoundException;
import com.kotbegemot.testtask2.service.implementation.BookServiceImpl;
import com.kotbegemot.testtask2.service.implementation.ReaderServiceImpl;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ValidLibraryRecordDTOValidator implements ConstraintValidator<ValidLibraryRecordDTO, LibraryRecordDTO> {
    private BookRepository bookService;
    private ReaderRepository readerService;

    public ValidLibraryRecordDTOValidator(BookRepository bookService1, ReaderRepository readerService1)
    {
        bookService = bookService1;
        readerService = readerService1;
    }
    @Override
    public void initialize(ValidLibraryRecordDTO constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LibraryRecordDTO libraryRecordDTO, ConstraintValidatorContext constraintValidatorContext) {
        libraryRecordDTO.setBook(bookService.findById(libraryRecordDTO.getBookId()).orElse(null));
        libraryRecordDTO.setReader(readerService.findById(libraryRecordDTO.getReaderId()).orElse(null));
        return libraryRecordDTO.getBook() != null && libraryRecordDTO.getReader() != null;
    }
}
