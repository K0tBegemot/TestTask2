package com.kotbegemot.testtask2.api.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.ISBN;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Entity класс для представления книги
 */
@Entity
@Table(name = "BOOK_TABLE", indexes = {@Index(name = "isbn_index", columnList = "book_isbn", unique = true)})
@NamedEntityGraph(
        name = "book_graph",
        attributeNodes = {
                @NamedAttributeNode("name"),
                @NamedAttributeNode("author"),
                @NamedAttributeNode("isbn")
        })
@NoArgsConstructor
@ToString
public class Book {
    /**
     * Уникальный идентификатор книги в БД
     */
    @Id
    @GeneratedValue(generator = "books-sequence")
    @GenericGenerator(
            name = "books-sequence",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "BOOK_TABLE_SEQ1"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Column(name = "book_id", nullable = true)
    @Getter
    @Setter
    private Long id;
    /**
     * Название книги
     */
    @Column(name = "book_name", nullable = false)
    @Getter
    @Setter
    @NotBlank
    private String name;
    /**
     * Автор книги
     */
    @Column(name = "book_author", nullable = false)
    @Getter
    @Setter
    @NotBlank
    private String author;
    /**
     * ISBN номер книги
     */
    @Column(name = "book_isbn", nullable = false, unique = true)
    @Getter
    @Setter
    @NotNull
    @ISBN
    private String isbn;
}
