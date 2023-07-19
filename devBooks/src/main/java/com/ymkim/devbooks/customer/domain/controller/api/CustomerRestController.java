package com.ymkim.devbooks.customer.domain.controller.api;

import com.ymkim.devbooks.customer.domain.dto.request.CreateCustomerRequestDto;
import com.ymkim.devbooks.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerRestController {
    private final CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<Long> createCustomer(@RequestBody CreateCustomerRequestDto createCustomerRequestDto) {
        long customerId = customerService.createCustomer(createCustomerRequestDto);
        return ResponseEntity
                .ok()
                .body(customerId);
    }
}
