package com.ymkim.devbooks.customer.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table("customer")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Customer {
    @Id
    @Column("customer_id")
    private Long customerId;
    @Column("name")
    private String name;
    @Column("phone")
    private String phone;
    @Column("address")
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
