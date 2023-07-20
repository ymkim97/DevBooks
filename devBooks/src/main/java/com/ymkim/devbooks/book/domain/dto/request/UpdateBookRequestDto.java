package com.ymkim.devbooks.book.domain.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record UpdateBookRequestDto(
        @NotNull Long bookId,
        @NotNull @Positive Long price
) {
}
