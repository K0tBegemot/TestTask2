package com.kotbegemot.testtask2.service.implementation;

import com.kotbegemot.testtask2.api.dto.reader.ReaderDTO;
import com.kotbegemot.testtask2.api.entity.Reader;
import com.kotbegemot.testtask2.api.mapper.ReaderMapper;
import com.kotbegemot.testtask2.repository.jpa.ReaderRepository;
import com.kotbegemot.testtask2.service.ReaderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReaderServiceImpl extends EntityServiceImpl<ReaderDTO, Reader, ReaderRepository, ReaderMapper> implements ReaderService {
    public ReaderServiceImpl(ReaderRepository readerRepository1, ReaderMapper readerMapper1)
    {
        super(readerRepository1, readerMapper1);
    }
}
