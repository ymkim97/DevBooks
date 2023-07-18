package com.ymkim.devbooks.customer.domain.dto.request;

import com.ymkim.devbooks.customer.domain.entity.Customer;

public record CreateCustomerRequestDto(
        String name, String phone, String address
) {
    public Customer toEntity() {
        return new Customer(this.name, this.phone, this.address);
    }
}
