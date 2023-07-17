package com.ymkim.devbooks.order.domain.entity;

import com.ymkim.devbooks.order.domain.dto.request.UpdateOrderRequestDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Table("ORDERS")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Order {
    @Id
    private long orderId;
    private String address;
    private String postcode;
    private LocalDateTime createdAt;
    private OrderStatus orderStatus;

    public Order(String address, String postcode, LocalDateTime createdAt, OrderStatus orderStatus) {
        this.address = address;
        this.postcode = postcode;
        this.createdAt = createdAt;
        this.orderStatus = orderStatus;
    }

    public void update(UpdateOrderRequestDto orderRequestDto) {
        this.address = orderRequestDto.address();
        this.postcode = orderRequestDto.postcode();
        this.orderStatus = orderRequestDto.orderStatus();
    }
}
