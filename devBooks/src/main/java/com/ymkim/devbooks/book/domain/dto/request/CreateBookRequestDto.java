package com.ymkim.devbooks.book.domain.dto.request;

import com.ymkim.devbooks.book.domain.entity.Book;
import com.ymkim.devbooks.book.domain.entity.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record CreateBookRequestDto(
        @NotBlank String title,
        @NotBlank String author,
        @NotNull Category category,
        @NotNull @Positive Long price,
        @NotNull LocalDate publishedAt
) {
    public Book toEntity() {
        return new Book(this.title, this.author, this.category, this.price, this.publishedAt);
    }
}
