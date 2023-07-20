package com.ymkim.devbooks.book.domain.entity;

import com.ymkim.devbooks.book.domain.dto.request.UpdateBookRequestDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Getter
@Table("book")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Book {
    @Id
    @Column("book_id")
    private Long bookId;
    @Column("title")
    private String title;
    @Column("author")
    private String author;
    @Column("category")
    private Category category;
    @Column("price")
    private Long price;
    @Column("published_at")
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
