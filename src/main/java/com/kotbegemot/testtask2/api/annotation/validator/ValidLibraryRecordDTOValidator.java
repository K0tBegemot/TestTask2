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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Service
public class ValidLibraryRecordDTOValidator implements ConstraintValidator<ValidLibraryRecordDTO, LibraryRecordDTO> {
    private static final Logger logger = LoggerFactory.getLogger(ValidLibraryRecordDTOValidator.class);
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
    @Transactional
    public boolean isValid(LibraryRecordDTO libraryRecordDTO, ConstraintValidatorContext constraintValidatorContext) {
        libraryRecordDTO.setBook(bookService.findById(libraryRecordDTO.getBookId()).orElse(null));
        libraryRecordDTO.setReader(readerService.findById(libraryRecordDTO.getReaderId()).orElse(null));
        System.err.println(libraryRecordDTO.getBook().toString() + " " + libraryRecordDTO.getReader());
        return libraryRecordDTO.getBook() != null && libraryRecordDTO.getReader() != null;
    }
}
