package com.kotbegemot.testtask2.api.dto.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.ISBN;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    @Getter @Setter
    @PositiveOrZero
    private Long id;
    @Getter @Setter
    @NotBlank
    private String name;
    @Getter @Setter
    @NotBlank
    private String author;
    @Getter @Setter
    @NotNull
    @ISBN
    private String isbn;
}
