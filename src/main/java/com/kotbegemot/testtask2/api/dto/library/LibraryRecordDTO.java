package com.kotbegemot.testtask2.api.dto.library;

import com.kotbegemot.testtask2.api.annotation.ValidDate;
import com.kotbegemot.testtask2.api.annotation.ValidLibraryRecordDTO;
import com.kotbegemot.testtask2.api.entity.Book;
import com.kotbegemot.testtask2.api.entity.Reader;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@AllArgsConstructor
@NoArgsConstructor
@ValidLibraryRecordDTO
@ToString
public class LibraryRecordDTO {
    @Getter @Setter
    @PositiveOrZero
    private Long id;
    @Getter @Setter
    private String pickupTime;
    @Getter @Setter
    @NotNull
    @PositiveOrZero
    private Long readerId;
    @Getter @Setter
    @NotNull
    @PositiveOrZero
    private Long bookId;
    @Getter @Setter
    private Reader reader;
    @Getter @Setter
    private Book book;
}
