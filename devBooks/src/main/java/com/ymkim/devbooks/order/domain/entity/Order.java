package com.ymkim.devbooks.order.domain.entity;

import com.ymkim.devbooks.orderitem.domain.entity.OrderItem;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Table("ORDERS")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Order {
    @Id
    private long orderId;
    private String address;
    private String postcode;
    private LocalDateTime createdAt;
    private List<OrderItem> orderItems;
    private OrderStatus orderStatus;

    public Order(String address, String postcode, LocalDateTime createdAt, List<OrderItem> orderItems, OrderStatus orderStatus) {
        this.address = address;
        this.postcode = postcode;
        this.createdAt = createdAt;
        this.orderItems = orderItems;
        this.orderStatus = orderStatus;
    }
}
