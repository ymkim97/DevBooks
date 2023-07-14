package com.ymkim.devbooks.order.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table("ORDER_ITEM")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderItem {
    @Id
    private long orderItemId;
    private long orderId;
    private long bookId;
    private int quantity;

    public OrderItem(long orderId, long bookId, int quantity) {
        this.orderId = orderId;
        this.bookId = bookId;
        this.quantity = quantity;
    }
}
