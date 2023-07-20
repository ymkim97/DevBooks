package com.ymkim.devbooks.order.item.service;

import com.ymkim.devbooks.order.item.domain.dto.OrderItemDto;

public interface OrderItemService {

    Long createOrderItem(OrderItemDto orderItemDto);
}
