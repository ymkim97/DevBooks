package com.ymkim.devbooks.book.service;

import com.ymkim.devbooks.book.domain.dto.BookDto;
import com.ymkim.devbooks.book.domain.dto.request.CreateBookRequestDto;
import com.ymkim.devbooks.book.domain.dto.request.UpdateBookRequestDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Long createBook(CreateBookRequestDto createBookRequestDto);

    Optional<BookDto> findBook(long id);

    List<BookDto> getAllBooks();

    void deleteBook(long id);

    BookDto updateBook(UpdateBookRequestDto updateBookRequestDto);
}
