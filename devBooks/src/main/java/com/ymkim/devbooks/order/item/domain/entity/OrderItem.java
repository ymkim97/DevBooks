package com.ymkim.devbooks.order.item.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table("order_item")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderItem {
    @Id
    @Column("order_item_id")
    private long orderItemId;
    @Column("order_id")
    private long orderId;
    @Column("book_id")
    private long bookId;
    @Column("quantity")
    private int quantity;

    public OrderItem(long orderId, long bookId, int quantity) {
        this.orderId = orderId;
        this.bookId = bookId;
        this.quantity = quantity;
    }
}
