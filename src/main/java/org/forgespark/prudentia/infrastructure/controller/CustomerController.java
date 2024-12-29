package org.forgespark.prudentia.infrastructure.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.forgespark.prudentia.application.dtos.CustomerDTO;
import org.forgespark.prudentia.application.usecases.customer.CreateCustomerUseCase;
import org.forgespark.prudentia.application.usecases.customer.FindAllCustomersUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final FindAllCustomersUseCase findAllCustomersUseCase;

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        CustomerDTO createdCustomerDTO = createCustomerUseCase.createCustomer(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomerDTO);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> findAllCustomers() {
        List<CustomerDTO> customersDTO = findAllCustomersUseCase.findAllCustomers();
        return ResponseEntity.status(HttpStatus.OK).body(customersDTO);
    }
}
