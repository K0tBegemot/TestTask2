package com.kotbegemot.testtask2.api.mapper;

import com.kotbegemot.testtask2.api.dto.reader.ReaderDTO;
import com.kotbegemot.testtask2.api.entity.Reader;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class ReaderMapper implements EntityMapper<Reader, ReaderDTO>{
    @Mapping(target = "birthday", source = "birthday", dateFormat = "dd-MM-yyyy")
    public abstract Reader dtoToEntity(ReaderDTO readerDTO);
    @Mapping(target = "birthday", source = "birthday", dateFormat = "dd-MM-yyyy")
    public abstract ReaderDTO entityToDTO(Reader reader);
    public abstract List<ReaderDTO> entityListToDTO(List<Reader> readerList);
}
