package com.kotbegemot.testtask2.api.dto.library;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kotbegemot.testtask2.api.dto.book.BookDTO;
import com.kotbegemot.testtask2.api.dto.library.jackson.ReaderBookMappingSerializer;
import com.kotbegemot.testtask2.api.dto.reader.ReaderDTO;
import com.kotbegemot.testtask2.repository.jpa.LibraryRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestLibraryResponse
{
    @JsonSerialize(using = ReaderBookMappingSerializer.class)
    private Map<ReaderDTO, List<LibraryRepository.BookProjection>> readerMapping = new HashMap<>();

    public void addMapping(ReaderDTO readerDTO, List<LibraryRepository.BookProjection> bookDTOList)
    {
        readerMapping.put(readerDTO, bookDTOList);
    }
}
