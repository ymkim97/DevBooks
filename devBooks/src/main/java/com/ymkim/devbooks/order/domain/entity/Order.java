package com.ymkim.devbooks.order.domain.entity;

import com.ymkim.devbooks.order.domain.dto.request.UpdateOrderRequestDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Table("orders")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Order {
    @Id
    @Column("order_id")
    private long orderId;
    @Column("customer_id")
    private long customerId;
    @Column("address")
    private String address;
    @Column("postcode")
    private String postcode;
    @Column("created_at")
    private LocalDateTime createdAt;
    @Column("order_status")
    private OrderStatus orderStatus;

    public Order(long customerId, String address, String postcode, LocalDateTime createdAt, OrderStatus orderStatus) {
        this.customerId = customerId;
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
