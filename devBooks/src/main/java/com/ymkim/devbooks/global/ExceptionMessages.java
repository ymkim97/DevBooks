package com.ymkim.devbooks.global;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ExceptionMessages {
    NO_BOOK_FOUND_BY_ID("THERE IS NO BOOK OF THIS ID");

    private final String message;
}
