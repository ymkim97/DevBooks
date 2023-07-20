package com.ymkim.devbooks.order.controller.api;

import com.ymkim.devbooks.order.domain.dto.OrderDto;
import com.ymkim.devbooks.order.domain.dto.request.CreateOrderRequestDto;
import com.ymkim.devbooks.order.domain.dto.request.UpdateOrderRequestDto;
import com.ymkim.devbooks.order.item.service.OrderItemService;
import com.ymkim.devbooks.order.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderRestController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Long> createOrder(@Valid @RequestBody CreateOrderRequestDto createOrderRequestDto) {
        Long orderId = orderService.createOrder(createOrderRequestDto);
        return ResponseEntity.ok().body(orderId);
    }

    @PutMapping
    public ResponseEntity<OrderDto> updateOrder(@Valid @RequestBody UpdateOrderRequestDto updateOrderRequestDto) {
        OrderDto orderDto = orderService.updateOrder(updateOrderRequestDto);
        return ResponseEntity.ok().body(orderDto);
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getOrders() {
        List<OrderDto> orders = orderService.getAllOrders();
        return ResponseEntity.ok().body(orders);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") long id) {
        orderService.deleteOrderById(id);
        return ResponseEntity.ok().body("Order Deleted Successfully!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable("id") long id) {
        Optional<OrderDto> order = orderService.findOrderById(id);
        return order.map(orderDto -> ResponseEntity.ok()
                .body(orderDto)).orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
