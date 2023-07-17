package com.ymkim.devbooks.book.domain.entity;

import com.ymkim.devbooks.book.domain.dto.request.UpdateBookRequestDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Getter
@Table("BOOK")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Book {
    @Id
    private long bookId;
    private String title;
    private String author;
    private Category category;
    private long price;
    private LocalDate publishedAt;

    public Book(String title, String author, Category category, long price, LocalDate publishedAt) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
        this.publishedAt = publishedAt;
    }

    public void update(UpdateBookRequestDto bookRequestDto) {
        this.price = bookRequestDto.price();
    }
}
