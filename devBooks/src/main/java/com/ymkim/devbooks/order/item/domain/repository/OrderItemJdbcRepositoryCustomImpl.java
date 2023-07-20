package com.ymkim.devbooks.order.item.domain.repository;

import com.ymkim.devbooks.order.item.domain.dto.OrderItemDto;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class OrderItemJdbcRepositoryCustomImpl implements OrderItemJdbcRepositoryCustom {

    @Override
    public Optional<OrderItemDto> findOrderItemByOrderId(long id) {
        return Optional.empty();
    }
}
