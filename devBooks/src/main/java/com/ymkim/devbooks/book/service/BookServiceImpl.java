package com.ymkim.devbooks.book.service;

import com.ymkim.devbooks.book.domain.dto.BookDto;
import com.ymkim.devbooks.book.domain.dto.request.CreateBookRequestDto;
import com.ymkim.devbooks.book.domain.dto.request.UpdateBookRequestDto;
import com.ymkim.devbooks.book.domain.entity.Book;
import com.ymkim.devbooks.book.domain.repository.BookJdbcRepository;
import com.ymkim.devbooks.global.ExceptionMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookJdbcRepository bookRepository;

    @Override
    @Transactional
    public Long createBook(CreateBookRequestDto createBookRequest) {
        Book savedBook = bookRepository.save(createBookRequest.toEntity());
        return savedBook.getBookId();
    }

    @Override
    public Optional<BookDto> findBookById(long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.map(BookDto::new);
    }

    @Override
    public List<BookDto> getAllBooks() {
        return StreamSupport.stream(bookRepository.findAll().spliterator(), false)
                .map(BookDto::new)
                .toList();
    }

    @Override
    @Transactional
    public void deleteBookById(long id) {
        bookRepository.deleteById(id);
    }

    @Override
    @Transactional
    public BookDto updateBook(UpdateBookRequestDto updateBookRequestDto) {
        Book book = bookRepository.findById(updateBookRequestDto.bookId())
                .orElseThrow(() -> new NoSuchElementException(ExceptionMessages.NO_BOOK_FOUND_BY_ID_ERROR.getMessage()));

        book.update(updateBookRequestDto);
        bookRepository.save(book);
        return new BookDto(book);
    }
}
