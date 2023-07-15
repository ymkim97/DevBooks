package com.ymkim.devbooks.book.domain.repository;

import com.ymkim.devbooks.book.domain.entity.Book;
import com.ymkim.devbooks.book.domain.entity.Category;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
@ActiveProfiles("test")
class BookJdbcRepositoryTest {

    @Autowired
    BookJdbcRepository repository;

    @AfterEach
    void clear() {
        repository.deleteAll();
    }

    @Test
    @DisplayName("Book save test")
    void saveTest() {
        // given
        Book book = new Book("TestBook",
                "TestAuthor",
                Category.FICTION,
                5000,
                LocalDateTime.now().toLocalDate()
        );


        // when
        repository.save(book);
        Optional<Book> savedBook = repository.findById(book.getBookId());

        // then
        assertThat(savedBook).isNotEmpty();
        assertThat(savedBook.get().getBookId()).isEqualTo(book.getBookId());
    }

    @Test
    @DisplayName("두개의 Book save test")
    void multipleSaveTest() {
        // given
        Book book1 = new Book(
                "TestBook",
                "TestAuthor",
                Category.FICTION,
                5000,
                LocalDateTime.now().toLocalDate()
        );

        Book book2 = new Book(
                "TestBook2",
                "TestAuthor2",
                Category.MYSTERY,
                2000,
                LocalDateTime.now().toLocalDate()
        );

        // when
        repository.save(book1);
        repository.save(book2);
        List<Book> savedBooks = StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .toList();

        // then
        assertThat(savedBooks).hasSize(2);
        savedBooks.forEach(book -> log.info("{}", book.getBookId()));
    }
}