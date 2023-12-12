package com.kotbegemot.testtask2.service;

import com.kotbegemot.testtask2.api.dto.reader.ReaderDTO;
import com.kotbegemot.testtask2.api.entity.Reader;
import com.kotbegemot.testtask2.api.mapper.ReaderMapper;
import com.kotbegemot.testtask2.repository.jpa.ReaderRepository;

import java.util.List;

public interface ReaderService extends EntityService<ReaderDTO, Reader, ReaderRepository, ReaderMapper>
{
    public List<Reader> findAll();
}