package com.ymkim.devbooks.customer.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table("CUSTOMER")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Customer {
    @Id
    private long customerId;
    private String name;
    private String phone;
    private String address;

    public Customer(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public void update(String phone, String address) {
        this.phone = phone;
        this.address = address;
    }
}
