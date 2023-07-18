package com.ymkim.devbooks.customer.domain.dto.request;

public record UpdateCustomerRequestDto(
        long customerId, String phone, String address
) {
}
