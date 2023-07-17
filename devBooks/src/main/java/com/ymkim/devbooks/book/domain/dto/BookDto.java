package com.ymkim.devbooks.book.domain.dto;

import com.ymkim.devbooks.book.domain.entity.Book;
import com.ymkim.devbooks.book.domain.entity.Category;

import java.time.LocalDate;

public record BookDto(
    long bookId, String title, String author, Category category, long price, LocalDate publishedAt
) {
    public BookDto (Book book) {
        this(book.getBookId(),
                book.getTitle(),
                book.getAuthor(),
                book.getCategory(),
                book.getPrice(),
                book.getPublishedAt());
    }
}