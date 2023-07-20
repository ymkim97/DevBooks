package com.ymkim.devbooks.book.service;

import com.ymkim.devbooks.book.domain.dto.BookDto;
import com.ymkim.devbooks.book.domain.dto.request.CreateBookRequestDto;
import com.ymkim.devbooks.book.domain.dto.request.UpdateBookRequestDto;
import com.ymkim.devbooks.book.domain.entity.Category;
import com.ymkim.devbooks.book.domain.repository.BookJdbcRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
@ActiveProfiles("test")
class BookServiceImplTest {

    @Autowired
    BookService bookService;

    @Autowired
    BookJdbcRepository bookRepository;

    @AfterEach
    void cleanUp() {
        bookRepository.deleteAll();
    }

    @Test
    @DisplayName("새로운 Book 생성 test")
    void createBookTest() {
        // given
        CreateBookRequestDto dto = new CreateBookRequestDto("Test", "TestAuthor", Category.COOK, 1000L, LocalDate.now());

        // when
        long id = bookService.createBook(dto);
        Optional<BookDto> bookDto = bookService.findBookById(id);

        // then
        assertThat(bookDto).isNotEmpty();
        log.info("Created ID -> {}", id);
    }

    @Test
    @DisplayName("모든 Book 가져오기 test")
    void getAllBooksTest() {
        // given
        CreateBookRequestDto dto1 = new CreateBookRequestDto("Test", "TestAuthor", Category.COOK, 1000L, LocalDate.now());
        CreateBookRequestDto dto2 = new CreateBookRequestDto("Test2", "TestAuthor2", Category.FICTION, 3000L, LocalDate.now());

        // when
        bookService.createBook(dto1);
        bookService.createBook(dto2);
        List<BookDto> allBooks = bookService.getAllBooks();

        // then
        assertThat(allBooks).hasSize(2);
    }

    @Test
    @DisplayName("Id로 Book 삭제 test")
    void deleteBookByIdTest() {
        // given
        CreateBookRequestDto dto1 = new CreateBookRequestDto("Test", "TestAuthor", Category.COOK, 1000L, LocalDate.now());
        CreateBookRequestDto dto2 = new CreateBookRequestDto("Test2", "TestAuthor2", Category.FICTION, 3000L, LocalDate.now());

        // when
        long id = bookService.createBook(dto1);
        bookService.createBook(dto2);
        bookService.deleteBookById(id);
        List<BookDto> allBooks = bookService.getAllBooks();

        // then
        assertThat(allBooks).hasSize(1);
    }

    @Test
    @DisplayName("Book 업데이트 test")
    void updateBook() {
        // given
        CreateBookRequestDto createBookRequestDto = new CreateBookRequestDto("Test", "TestAuthor", Category.COOK, 1000L, LocalDate.now());
        Long bookId = bookService.createBook(createBookRequestDto);
        UpdateBookRequestDto updateBookRequestDto = new UpdateBookRequestDto(bookId, 5000L);

        // when
        bookService.updateBook(updateBookRequestDto);
        BookDto book = bookService.findBookById(bookId).get();

        // then
        assertThat(book.price()).isEqualTo(5000);
    }
}
