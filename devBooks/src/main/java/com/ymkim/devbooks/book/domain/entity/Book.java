package com.ymkim.devbooks.book.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Getter
@Table("BOOKS")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Book {
    @Id
    private long bookId;
    private String title;
    private String author;
    private Category category;
    private long price;
    private LocalDate publishedAt;

    @Builder
    @PersistenceCreator
    public Book(String title, String author, Category category, long price, LocalDate publishedAt) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
        this.publishedAt = publishedAt;
    }
}
