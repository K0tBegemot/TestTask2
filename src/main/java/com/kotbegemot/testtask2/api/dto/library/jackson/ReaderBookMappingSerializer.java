package com.kotbegemot.testtask2.api.dto.library.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.kotbegemot.testtask2.api.dto.book.BookDTO;
import com.kotbegemot.testtask2.api.dto.reader.ReaderDTO;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReaderBookMappingSerializer extends JsonSerializer<Map<ReaderDTO, List<BookDTO>>> {

    @Override
    public void serialize(Map<ReaderDTO, List<BookDTO>> readerDTOListMap, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if(readerDTOListMap == null)
        {
//            jsonGenerator.writeStartArray();
//            jsonGenerator.writeEndArray();
            return;
        }
        Set<ReaderDTO> readerSet = readerDTOListMap.keySet();
        jsonGenerator.writeStartArray();
        for(ReaderDTO reader : readerSet)
        {
            List<BookDTO> bookList = readerDTOListMap.get(reader);
            jsonGenerator.writeStartObject();
            jsonGenerator.writeObjectField("reader", reader);
            jsonGenerator.writeObjectField("bookList", bookList);
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();
    }
}
