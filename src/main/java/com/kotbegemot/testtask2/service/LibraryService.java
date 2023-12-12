package com.kotbegemot.testtask2.service;

import com.kotbegemot.testtask2.api.dto.book.BookDTO;
import com.kotbegemot.testtask2.api.dto.library.LibraryRecordDTO;
import com.kotbegemot.testtask2.api.dto.reader.ReaderDTO;
import com.kotbegemot.testtask2.api.entity.LibraryRecord;
import com.kotbegemot.testtask2.api.entity.Reader;
import com.kotbegemot.testtask2.api.mapper.LibraryMapper;
import com.kotbegemot.testtask2.repository.jpa.LibraryRepository;

import java.util.List;

public interface LibraryService extends EntityService<LibraryRecordDTO, LibraryRecord, LibraryRepository, LibraryMapper> {
    public List<LibraryRepository.BookProjection> findAllBookByReader(Reader reader);
}
