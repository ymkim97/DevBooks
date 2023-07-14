package com.ymkim.devbooks.book.domain.repository;

import com.ymkim.devbooks.book.domain.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookJdbcRepository extends CrudRepository<Book, Long> {
}
