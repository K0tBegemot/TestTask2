package com.kotbegemot.testtask2.api.dto;

import com.kotbegemot.testtask2.api.dto.book.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Paged<T> {
    @Getter @Setter
    private List<T> objectList;
    @Getter @Setter
    private Integer number;
    @Getter @Setter
    private Integer allPageNumber;
    @Getter @Setter
    private Integer size;
}
