package com.kotbegemot.testtask2.service;

import com.kotbegemot.testtask2.api.dto.book.BookDTO;
import com.kotbegemot.testtask2.api.dto.library.LibraryRecordDTO;
import com.kotbegemot.testtask2.api.dto.reader.ReaderDTO;
import com.kotbegemot.testtask2.api.entity.LibraryRecord;
import com.kotbegemot.testtask2.api.entity.Reader;
import com.kotbegemot.testtask2.api.mapper.LibraryMapper;
import com.kotbegemot.testtask2.repository.jpa.LibraryRepository;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.Optional;

public interface LibraryService extends EntityService<LibraryRecordDTO, LibraryRecord, LibraryRepository, LibraryMapper> {
    public List<LibraryRepository.BookProjection> findAllBookByReader(Reader reader);
    public Optional<List<FieldError>> saveAndValidateEntity(LibraryRecordDTO recordDTO);
}
