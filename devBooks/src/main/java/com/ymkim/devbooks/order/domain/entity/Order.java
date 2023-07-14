package com.ymkim.devbooks.order.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table("ORDERS")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Order {
    @Id
    private long orderId;

}
