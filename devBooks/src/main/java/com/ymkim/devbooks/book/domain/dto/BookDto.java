package com.ymkim.devbooks.book.domain.dto;

import com.ymkim.devbooks.book.domain.entity.Book;
import com.ymkim.devbooks.book.domain.entity.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record BookDto(
        @NotBlank String title,
        @NotBlank String author,
        @NotNull Category category,
        @NotNull @Positive Long price,
        @NotNull LocalDate publishedAt
) {
    public BookDto (Book book) {
        this(book.getTitle(),
            book.getAuthor(),
            book.getCategory(),
            book.getPrice(),
            book.getPublishedAt());
    }
}
