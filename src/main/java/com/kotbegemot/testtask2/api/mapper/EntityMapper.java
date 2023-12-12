package com.kotbegemot.testtask2.api.mapper;

import com.kotbegemot.testtask2.api.dto.book.BookDTO;
import com.kotbegemot.testtask2.api.entity.Book;
import com.kotbegemot.testtask2.api.mapper.annotation.DoIgnore;
import org.mapstruct.Qualifier;

import java.util.List;

public interface EntityMapper<E, T> {

    @DoIgnore
    public E dtoToEntity(T entityDTO);
    @DoIgnore
    public T entityToDTO(E book);
    @DoIgnore
    public List<T> entityListToDTO(List<E> entityList);
}
