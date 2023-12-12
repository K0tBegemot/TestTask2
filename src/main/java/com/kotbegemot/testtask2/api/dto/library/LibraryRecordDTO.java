package com.kotbegemot.testtask2.api.dto.library;

import com.kotbegemot.testtask2.api.annotation.ValidDate;
import com.kotbegemot.testtask2.api.annotation.ValidLibraryRecordDTO;
import com.kotbegemot.testtask2.api.entity.Book;
import com.kotbegemot.testtask2.api.entity.Reader;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@AllArgsConstructor
@NoArgsConstructor
@ValidLibraryRecordDTO
public class LibraryRecordDTO {
    @Getter @Setter
    @PositiveOrZero
    private Long id;
    @Getter @Setter
    @ValidDate
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
