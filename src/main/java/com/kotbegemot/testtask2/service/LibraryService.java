package com.kotbegemot.testtask2.service;

import com.kotbegemot.testtask2.api.dto.library.LibraryRecordDTO;
import com.kotbegemot.testtask2.api.entity.LibraryRecord;
import com.kotbegemot.testtask2.api.mapper.LibraryMapper;
import com.kotbegemot.testtask2.repository.jpa.LibraryRepository;

public interface LibraryService extends EntityService<LibraryRecordDTO, LibraryRecord, LibraryRepository, LibraryMapper> {
}
