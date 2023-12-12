package com.kotbegemot.testtask2.service.implementation;

import com.kotbegemot.testtask2.api.dto.Paged;
import com.kotbegemot.testtask2.api.mapper.EntityMapper;
import com.kotbegemot.testtask2.service.EntityService;
import com.kotbegemot.testtask2.service.exception.EntityNotFoundException;
import com.kotbegemot.testtask2.service.util.PageUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Transactional
public class EntityServiceImpl<T, E, R extends JpaRepository<E, Long>, M extends EntityMapper<E, T>> implements EntityService<T, E, R, M> {
    protected R repository;
    protected M mapper;
    public EntityServiceImpl(R repository1, M mapper1)
    {
        repository = repository1;
        mapper = mapper1;
    }
    @Override
    public Paged<T> getPageByNumber(Integer pageNumber, Integer pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        Page<E> pageResult = repository.findAll(page);
        PageUtils.checkPageNumber(pageResult, pageNumber);
        return new Paged<>(mapper.entityListToDTO(pageResult.getContent()), pageNumber, pageResult.getTotalPages(), pageSize);
    }

    @Override
    public T getEntityDTOById(Long id) {
        Optional<E> entity = repository.findById(id);
        if (entity.isPresent()) {
            return mapper.entityToDTO(entity.get());
        }
        throw new EntityNotFoundException();
    }

    @Override
    public void saveOrUpdateEntity(T dto) {
        E entity = mapper.dtoToEntity(dto);
        repository.save(entity);
    }
}
