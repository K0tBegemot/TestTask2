package com.kotbegemot.testtask2.api.entity;

import com.kotbegemot.testtask2.api.annotation.ValidDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;

/**
 * Entity класс для хранения информации о взятии книги читателем
 */
@Entity
@Table(name = "LIBRARY_RECORD_TABLE", indexes = {
        @Index(name = "reader_index", columnList = "reader_id", unique = false),
        @Index(name = "book_index", columnList = "book_id", unique = false)})
@NoArgsConstructor
@ToString
public class LibraryRecord {
        /**
         * Уникальный идентификатор записи в БД
         */
        @Id
        @GeneratedValue(generator = "library-record-sequence")
        @GenericGenerator(
                name = "library-record-sequence",
                strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
                parameters = {
                        @org.hibernate.annotations.Parameter(name = "sequence_name", value = "LIBRARY_RECORD_TABLE_SEQ1"),
                        @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                        @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
                }
        )
        @Column(name = "record_id", nullable = true)
        @Getter
        @Setter
        @PositiveOrZero
        private Long id;
        @Column(name = "book_pickup_time", nullable = false)
        @Getter @Setter
        private LocalDateTime pickupTime;
        @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        @JoinColumn(name = "reader_id")
        @Getter @Setter
        private Reader reader;
        @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        @JoinColumn(name = "book_id")
        @Getter @Setter
        private Book book;
}
