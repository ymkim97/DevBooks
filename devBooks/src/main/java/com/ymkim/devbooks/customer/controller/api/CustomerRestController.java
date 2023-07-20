package com.ymkim.devbooks.customer.controller.api;

import com.ymkim.devbooks.customer.domain.dto.CustomerDto;
import com.ymkim.devbooks.customer.domain.dto.request.CreateCustomerRequestDto;
import com.ymkim.devbooks.customer.domain.dto.request.UpdateCustomerRequestDto;
import com.ymkim.devbooks.customer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerRestController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<Long> createCustomer(@Valid  @RequestBody CreateCustomerRequestDto createCustomerRequestDto) {
        long customerId = customerService.createCustomer(createCustomerRequestDto);
        return ResponseEntity.ok().body(customerId);
    }

    @PutMapping
    public ResponseEntity<CustomerDto> updateCustomer(@Valid @RequestBody UpdateCustomerRequestDto updateCustomerRequestDto) {
        CustomerDto customerDto = customerService.updateCustomer(updateCustomerRequestDto);
        return ResponseEntity.ok().body(customerDto);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getCustomers() {
        List<CustomerDto> customers = customerService.getAllCustomers();
        return ResponseEntity.ok().body(customers);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id) {
        customerService.deleteCustomerById(id);
        return ResponseEntity.ok().body("Customer Deleted Successfully!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("id") long id) {
        Optional<CustomerDto> customer = customerService.findCustomerById(id);
        return customer.map(customerDto -> ResponseEntity.ok()
                .body(customerDto)).orElseGet(() -> (ResponseEntity.badRequest().build()));
    }
}
