package com.kotbegemot.testtask2.api.dto.reader;

import com.kotbegemot.testtask2.repository.jpa.LibraryRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class RestReaderDTO {
    @Getter @Setter
    private ReaderDTO readerDTO;
    @Getter @Setter
    private List<LibraryRepository.ReaderProjection> readerProjections;
}
