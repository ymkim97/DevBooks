package com.ymkim.devbooks.book.domain.dto.request;

import com.ymkim.devbooks.book.domain.entity.Book;
import com.ymkim.devbooks.book.domain.entity.Category;

import java.time.LocalDate;

public record CreateBookRequestDto(
        String title, String author, Category category, long price, LocalDate publishedAt
) {
    public Book toEntity() {
        return new Book(this.title, this.author, this.category, this.price, this.publishedAt);
    }
}
