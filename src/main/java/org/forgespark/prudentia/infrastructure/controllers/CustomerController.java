package org.forgespark.prudentia.infrastructure.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.forgespark.prudentia.application.dtos.customer.CustomerCreateDTO;
import org.forgespark.prudentia.application.dtos.customer.CustomerDTO;
import org.forgespark.prudentia.application.usecases.customer.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final FindAllCustomersUseCase findAllCustomersUseCase;
    private final FindCustomerByIDUseCase findCustomerByIDUseCase;
    private final FindCustomerByCPFUseCase findCustomerByCPFUseCase;
    private final UpdateCustomerUseCase updateCustomerUseCase;
    private final DeleteCustomerUseCase deleteCustomerUseCase;

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody @Valid CustomerCreateDTO customerCreateDTO) {
        CustomerDTO createdCustomerCreateDTO = createCustomerUseCase.execute(customerCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomerCreateDTO);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> findAllCustomers() {
        List<CustomerDTO> customerDTO = findAllCustomersUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK).body(customerDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> findCustomerById(@PathVariable @NotNull UUID id) {
        CustomerDTO customerDTO = findCustomerByIDUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(customerDTO);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<CustomerDTO> findByCpf(@PathVariable @NotNull @CPF String cpf) {
        CustomerDTO customerDTO = findCustomerByCPFUseCase.execute(cpf);
        return ResponseEntity.status(HttpStatus.OK).body(customerDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable @NotNull UUID id,
                                                      @RequestBody @Valid CustomerDTO customerDTO) {
        CustomerDTO updatedCustomer = updateCustomerUseCase.execute(id, customerDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable @NotNull UUID id) {
        deleteCustomerUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
