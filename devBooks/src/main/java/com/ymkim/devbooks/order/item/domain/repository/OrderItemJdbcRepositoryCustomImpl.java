package com.ymkim.devbooks.order.item.domain.repository;

import com.ymkim.devbooks.order.item.domain.dto.OrderItemDto;

import java.util.Optional;

public class OrderItemJdbcRepositoryCustomImpl implements OrderItemJdbcRepositoryCustom {
    @Override
    public Optional<OrderItemDto> findOrderItemByOrderId(long id) {
        return Optional.empty();
    }
}
