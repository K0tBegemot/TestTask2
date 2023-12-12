package com.kotbegemot.testtask2.api.dto.reader;

import com.kotbegemot.testtask2.api.annotation.ValidDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@AllArgsConstructor
@NoArgsConstructor
public class ReaderDTO {
    @Getter @Setter
    @PositiveOrZero
    private Long id;
    @Getter @Setter
    @NotBlank
    private String firstName;
    @Getter @Setter
    @NotBlank
    private String secondName;
    @Getter @Setter
    @NotBlank
    private String lastName;
    @Getter @Setter
    @NotBlank
    @ValidDate
    private String birthday;
}
