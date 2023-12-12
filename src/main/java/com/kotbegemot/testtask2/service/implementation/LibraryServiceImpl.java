package com.kotbegemot.testtask2.service.implementation;

import com.kotbegemot.testtask2.api.dto.book.BookDTO;
import com.kotbegemot.testtask2.api.dto.library.LibraryRecordDTO;
import com.kotbegemot.testtask2.api.dto.reader.ReaderDTO;
import com.kotbegemot.testtask2.api.entity.Book;
import com.kotbegemot.testtask2.api.entity.LibraryRecord;
import com.kotbegemot.testtask2.api.entity.Reader;
import com.kotbegemot.testtask2.api.mapper.LibraryMapper;
import com.kotbegemot.testtask2.repository.jpa.BookRepository;
import com.kotbegemot.testtask2.repository.jpa.LibraryRepository;
import com.kotbegemot.testtask2.repository.jpa.ReaderRepository;
import com.kotbegemot.testtask2.service.BookService;
import com.kotbegemot.testtask2.service.LibraryService;
import com.kotbegemot.testtask2.service.ReaderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LibraryServiceImpl extends EntityServiceImpl<LibraryRecordDTO, LibraryRecord, LibraryRepository, LibraryMapper> implements LibraryService {
    private BookRepository bookService;
    private ReaderRepository readerService;
    public LibraryServiceImpl(LibraryRepository repository, LibraryMapper mapper, BookRepository bookService1, ReaderRepository readerService1)
    {
        super(repository, mapper);
        bookService = bookService1;
        readerService = readerService1;
    }

    @Override
    public List<LibraryRepository.BookProjection> findAllBookByReader(Reader reader)
    {
        return repository.findAllBooksByReader(reader);
    }

    @Override
    public Optional<List<FieldError>> saveAndValidateEntity(LibraryRecordDTO recordDTO)
    {
        Optional<Book> book = bookService.findById(recordDTO.getBookId());
        Optional<Reader> reader = readerService.findById(recordDTO.getReaderId());
        if(book.isPresent()&&reader.isPresent())
        {
            LibraryRecord libraryRecord = mapper.dtoToEntity(recordDTO);
            libraryRecord.setBook(book.get());
            libraryRecord.setReader(reader.get());
            repository.save(libraryRecord);
            return Optional.empty();
        }
        List<FieldError> errorList = new ArrayList<>();
        if(!book.isPresent())
        {
            errorList.add(new FieldError("newEntity", "bookId", "Нет книги с таким идентификатором"));
        }
        if(!reader.isPresent())
        {
            errorList.add(new FieldError("newEntity", "readerId", "Нет читателя с таким идентификатором"));
        }
        return Optional.of(errorList);
    }
}
