package com.kotbegemot.testtask2.service.implementation;

import com.kotbegemot.testtask2.api.dto.library.LibraryRecordDTO;
import com.kotbegemot.testtask2.api.entity.LibraryRecord;
import com.kotbegemot.testtask2.api.mapper.LibraryMapper;
import com.kotbegemot.testtask2.repository.jpa.LibraryRepository;
import com.kotbegemot.testtask2.service.LibraryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LibraryServiceImpl extends EntityServiceImpl<LibraryRecordDTO, LibraryRecord, LibraryRepository, LibraryMapper> implements LibraryService {
    public LibraryServiceImpl(LibraryRepository repository, LibraryMapper mapper)
    {
        super(repository, mapper);
    }
}
