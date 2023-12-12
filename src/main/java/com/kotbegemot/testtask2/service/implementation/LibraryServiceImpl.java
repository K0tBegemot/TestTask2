package com.kotbegemot.testtask2.service.implementation;

import com.kotbegemot.testtask2.api.dto.book.BookDTO;
import com.kotbegemot.testtask2.api.dto.library.LibraryRecordDTO;
import com.kotbegemot.testtask2.api.dto.reader.ReaderDTO;
import com.kotbegemot.testtask2.api.entity.LibraryRecord;
import com.kotbegemot.testtask2.api.entity.Reader;
import com.kotbegemot.testtask2.api.mapper.LibraryMapper;
import com.kotbegemot.testtask2.repository.jpa.LibraryRepository;
import com.kotbegemot.testtask2.service.LibraryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LibraryServiceImpl extends EntityServiceImpl<LibraryRecordDTO, LibraryRecord, LibraryRepository, LibraryMapper> implements LibraryService {
    public LibraryServiceImpl(LibraryRepository repository, LibraryMapper mapper)
    {
        super(repository, mapper);
    }

    @Override
    public List<LibraryRepository.BookProjection> findAllBookByReader(Reader reader)
    {
        return repository.findAllBooksByReader(reader);
    }
}
