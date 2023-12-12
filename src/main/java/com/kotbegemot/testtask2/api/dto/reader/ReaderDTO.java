package com.kotbegemot.testtask2.api.dto.reader;

import com.kotbegemot.testtask2.api.annotation.ValidDate;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
public class ReaderDTO {
    @Getter @Setter
    @PositiveOrZero
    private Long id;
    @Getter @Setter
    @NotBlank
    private String firstName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReaderDTO)) return false;
        ReaderDTO readerDTO = (ReaderDTO) o;
        return Objects.equals(id, readerDTO.id) && firstName.equals(readerDTO.firstName) && secondName.equals(readerDTO.secondName) && lastName.equals(readerDTO.lastName) && birthday.equals(readerDTO.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName, lastName, birthday);
    }

    @Getter @Setter
    @NotBlank
    private String secondName;
    @Getter @Setter
    @NotBlank
    private String lastName;
    @Getter @Setter
    @NotNull
//    @ValidDate
    private String birthday;
}
