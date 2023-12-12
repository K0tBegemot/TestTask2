package com.kotbegemot.testtask2.api.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

/**
 * Entity класс для представления читателя
 */
@Entity
@Table(name = "READER_TABLE")
@NamedEntityGraph(
        name = "reader_graph",
        attributeNodes = {
                @NamedAttributeNode("firstName"),
                @NamedAttributeNode("secondName"),
                @NamedAttributeNode("lastName"),
                @NamedAttributeNode("birthday")
        })
@NoArgsConstructor
@ToString
public class Reader {
        /**
         * Уникальный идентификатор читателя в БД
         */
        @Id
        @GeneratedValue(generator = "reader-sequence")
        @GenericGenerator(
                name = "reader-sequence",
                strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
                parameters = {
                        @org.hibernate.annotations.Parameter(name = "sequence_name", value = "READER_TABLE_SEQ1"),
                        @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                        @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
                }
        )
        @Column(name = "reader_id", nullable = true)
        @Getter
        @Setter
        private Long id;
        /**
         * Имя читателя
         */
        @Column(name = "reader_first_name", nullable = false)
        @NotBlank
        @Getter @Setter
        private String firstName;
        /**
         * Фамилия читателя
         */
        @Column(name = "reader_second_name", nullable = false)
        @NotBlank
        @Getter @Setter
        private String secondName;
        /**
         * Отчество читателя
         */
        @Column(name = "reader_last_name", nullable = false)
        @Getter @Setter
        @NotBlank
        private String lastName;
        /**
         * День рождения читателя
         */
        @Column(name = "reader_birthday", nullable = false)
        @Getter @Setter
        @PastOrPresent
        private LocalDate birthday;
}
