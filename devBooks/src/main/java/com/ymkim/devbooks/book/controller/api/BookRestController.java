package com.ymkim.devbooks.book.controller.api;

import com.ymkim.devbooks.book.domain.dto.BookDto;
import com.ymkim.devbooks.book.domain.dto.request.CreateBookRequestDto;
import com.ymkim.devbooks.book.domain.dto.request.UpdateBookRequestDto;
import com.ymkim.devbooks.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/book")
public class BookRestController {
    private final BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<Long> createBook(@RequestBody CreateBookRequestDto createBookRequestDto) {
        long bookId = bookService.createBook(createBookRequestDto);
        return ResponseEntity
                .ok()
                .body(bookId);
    }

    @PutMapping("/update")
    public ResponseEntity<BookDto> updateBook(@RequestBody UpdateBookRequestDto updateBookRequestDto) {
        BookDto bookDto = bookService.updateBook(updateBookRequestDto);
        return ResponseEntity
                .ok()
                .body(bookDto);
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookDto>> getBooks() {
        List<BookDto> books = bookService.getAllBooks();
        return ResponseEntity
                .ok()
                .body(books);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") long id) {
        bookService.deleteBookById(id);
        return ResponseEntity
                .ok()
                .body("Deleted Successfully!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBook(@PathVariable("id") long id) {
        Optional<BookDto> book = bookService.findBookById(id);
        return book.map(bookDto -> ResponseEntity.ok()
                .body(bookDto)).orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
