package com.ymkim.devbooks.order.item.domain.repository;

import com.ymkim.devbooks.order.item.domain.dto.OrderItemDto;

import java.util.Optional;

public interface OrderItemJdbcRepositoryCustom {
    Optional<OrderItemDto> findOrderItemByOrderId(long id);
}
