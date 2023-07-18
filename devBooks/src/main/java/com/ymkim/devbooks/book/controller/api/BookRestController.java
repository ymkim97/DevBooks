package com.ymkim.devbooks.book.controller.api;

import com.ymkim.devbooks.book.domain.dto.request.CreateBookRequestDto;
import com.ymkim.devbooks.book.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookRestController {
    private final BookService bookService;

    @PostMapping("/api/v1/book/create")
    public ResponseEntity<Long> createBook(@RequestBody CreateBookRequestDto createBookRequestDto) {
        Long bookId = bookService.createBook(createBookRequestDto);
        return ResponseEntity.ok(bookId);
    }
}
