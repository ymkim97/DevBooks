package com.ymkim.devbooks.book.domain.repository;

import com.ymkim.devbooks.book.domain.entity.Book;
import com.ymkim.devbooks.book.domain.entity.Category;
import org.junit.jupiter.api.BeforeEach;
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

@SpringBootTest
@ActiveProfiles("test")
class BookJdbcRepositoryTest {

    @Autowired
    BookJdbcRepository repository;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
    }

    @Test
    @DisplayName("Book save test")
    void saveTest() {
        // given
        Book book = Book.builder()
                .title("TestBook")
                .author("TestAuthor")
                .price(5000)
                .category(Category.FICTION)
                .publishedAt(LocalDateTime.now().toLocalDate())
                .build();

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
        Book book1 = Book.builder()
                .title("TestBook")
                .author("TestAuthor")
                .price(5000)
                .category(Category.FICTION)
                .publishedAt(LocalDateTime.now().toLocalDate())
                .build();

        Book book2 = Book.builder()
                .title("TestBook2")
                .author("TestAuthor2")
                .price(3000)
                .category(Category.MYSTERY)
                .publishedAt(LocalDateTime.now().toLocalDate())
                .build();

        // when
        repository.save(book1);
        repository.save(book2);
        List<Book> savedBooks = StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .toList();

        // then
        assertThat(savedBooks).hasSize(2);
    }
}