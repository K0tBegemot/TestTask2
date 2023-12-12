package com.kotbegemot.testtask2.controller;

import com.kotbegemot.testtask2.api.dto.library.RestLibraryResponse;
import com.kotbegemot.testtask2.api.entity.Reader;
import com.kotbegemot.testtask2.api.mapper.ReaderMapper;
import com.kotbegemot.testtask2.service.LibraryService;
import com.kotbegemot.testtask2.service.ReaderService;
import com.kotbegemot.testtask2.service.implementation.LibraryServiceImpl;
import com.kotbegemot.testtask2.service.implementation.ReaderServiceImpl;
import net.bytebuddy.asm.MemberSubstitution;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/library")
public class RestfulController {
    private ReaderService readerService;
    private LibraryService libraryService;
    private ReaderMapper readerMapper;

    public RestfulController(ReaderServiceImpl readerService1, LibraryServiceImpl libraryService1, ReaderMapper readerMapper1)
    {
        readerService = readerService1;
        libraryService = libraryService1;
        readerMapper = readerMapper1;
    }

    @GetMapping(value = "/get/records", produces = MediaType.APPLICATION_JSON_VALUE)
    public RestLibraryResponse getReaderToBookMapping()
    {
        RestLibraryResponse restLibraryResponse = new RestLibraryResponse();
        List<Reader> readers = readerService.findAll();
        for(Reader reader: readers)
        {
            restLibraryResponse.addMapping(readerMapper.entityToDTO(reader), libraryService.findAllBookByReader(reader));
        }
        return restLibraryResponse;
    }
}
