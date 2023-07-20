package com.ymkim.devbooks.order.item.service;

import com.ymkim.devbooks.order.item.domain.dto.request.CreateOrderItemRequestDto;

public interface OrderItemService {

    Long createOrderItem(CreateOrderItemRequestDto createOrderItemRequestDto);
}
