package com.ymkim.devbooks.global;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ExceptionMessages {
    NO_BOOK_FOUND_BY_ID_ERROR("THERE IS NO BOOK OF THIS ID"),
    NO_ORDER_FOUND_BY_ID_ERROR("THERE IS NO ORDER OF THIS ID"),
    NO_CUSTOMER_FOUND_BY_ID_ERROR("THERE IS NO CUSTOMER OF THIS ID");

    private final String message;
}
