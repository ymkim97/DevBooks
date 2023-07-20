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
    private Long orderItemId;
    @Column("order_id")
    private Long orderId;
    @Column("book_id")
    private Long bookId;
    @Column("quantity")
    private Integer quantity;

    public OrderItem(long orderId, long bookId, int quantity) {
        this.orderId = orderId;
        this.bookId = bookId;
        this.quantity = quantity;
    }
}
