package com.ymkim.devbooks.order.item.service;

import com.ymkim.devbooks.order.item.domain.dto.OrderItemDto;
import com.ymkim.devbooks.order.item.domain.dto.request.CreateOrderItemRequestDto;
import com.ymkim.devbooks.order.item.domain.entity.OrderItem;
import com.ymkim.devbooks.order.item.domain.repository.OrderItemJdbcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemJdbcRepository orderItemRepository;

    @Override
    @Transactional
    public Long createOrderItem(OrderItemDto orderItemDto) {
        OrderItem orderItem = orderItemRepository.save(orderItemDto.toEntity());
        return orderItem.getOrderItemId();
    }
}
