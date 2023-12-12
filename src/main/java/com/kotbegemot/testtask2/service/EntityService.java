package com.kotbegemot.testtask2.service;

import com.kotbegemot.testtask2.api.dto.Paged;
import com.kotbegemot.testtask2.api.mapper.EntityMapper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityService<T, E, R extends JpaRepository<E, Long>, M extends EntityMapper<E, T>> {
    public Paged<T> getPageByNumber(Integer pageNumber, Integer pageSize);
    public T getEntityDTOById(Long id);
    public void saveOrUpdateEntity(T bookDTO);
}
