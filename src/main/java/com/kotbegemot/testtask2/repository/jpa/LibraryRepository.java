package com.kotbegemot.testtask2.repository.jpa;

import com.kotbegemot.testtask2.api.entity.Book;
import com.kotbegemot.testtask2.api.entity.LibraryRecord;
import com.kotbegemot.testtask2.api.entity.Reader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface LibraryRepository extends JpaRepository<LibraryRecord, Long> {
    public interface BookProjection
    {
        public Book getBook();
        public LocalDateTime getPickupTime();
    }
    public interface ReaderProjection
    {
        public Reader getReader();
        public LocalDateTime getPickupTime();
    }
    @Query(name = "readerQuery", value = "SELECT r.reader as reader, r.pickupTime as pickupTime FROM LibraryRecord r WHERE r.book = :book order by r.pickupTime")
    public List<ReaderProjection> findAllReadersByBook(@Param("book") Book book);
    public Slice<ReaderProjection> findAllByBookOrderByPickupTimeAsc(Book book, Pageable pageable);
    @Query(name = "bookQuery", value = "SELECT r.book as book, r.pickupTime as pickupTime FROM LibraryRecord r WHERE r.reader = :reader order by r.pickupTime")
    public List<BookProjection> findAllBooksByReader(@Param("reader") Reader reader);
    public Slice<ReaderProjection> findAllByReaderOrderByPickupTimeAsc(Reader reader, Pageable pageable);
}
