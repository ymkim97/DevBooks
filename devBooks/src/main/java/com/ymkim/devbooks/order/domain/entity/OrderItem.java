package com.ymkim.devbooks.order.domain.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table("ORDER_ITEM")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class OrderItem {
    @Id
    private long orderItemId;
    private long bookId;
    private int quantity;
}
