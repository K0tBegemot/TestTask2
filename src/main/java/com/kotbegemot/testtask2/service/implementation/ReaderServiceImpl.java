package com.kotbegemot.testtask2.service.implementation;

import com.kotbegemot.testtask2.api.dto.reader.ReaderDTO;
import com.kotbegemot.testtask2.api.entity.Reader;
import com.kotbegemot.testtask2.api.mapper.ReaderMapper;
import com.kotbegemot.testtask2.repository.jpa.ReaderRepository;
import com.kotbegemot.testtask2.service.ReaderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReaderServiceImpl extends EntityServiceImpl<ReaderDTO, Reader, ReaderRepository, ReaderMapper> implements ReaderService {
    private final ReaderRepository readerRepository;

    public ReaderServiceImpl(ReaderRepository readerRepository1, ReaderMapper readerMapper1,
                             ReaderRepository readerRepository)
    {
        super(readerRepository1, readerMapper1);
        this.readerRepository = readerRepository;
    }

    @Override
    public List<Reader> findAll()
    {
        return readerRepository.findAll();
    }
}
