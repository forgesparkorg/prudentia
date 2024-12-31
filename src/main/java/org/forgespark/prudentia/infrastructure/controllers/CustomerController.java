package org.forgespark.prudentia.infrastructure.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.forgespark.prudentia.application.dtos.customer.CustomerCreateDTO;
import org.forgespark.prudentia.application.dtos.customer.CustomerResponseDTO;
import org.forgespark.prudentia.application.usecases.customer.CreateCustomerUseCase;
import org.forgespark.prudentia.application.usecases.customer.FindAllCustomersUseCase;
import org.forgespark.prudentia.application.usecases.customer.FindCustomerByCPFUseCase;
import org.forgespark.prudentia.application.usecases.customer.FindCustomerByIDUseCase;
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

    @PostMapping
    public ResponseEntity<CustomerResponseDTO> createCustomer(@RequestBody @Valid CustomerCreateDTO customerCreateDTO) {
        CustomerResponseDTO createdCustomerCreateDTO = createCustomerUseCase.execute(customerCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomerCreateDTO);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>> findAllCustomers() {
        List<CustomerResponseDTO> customerResponseDTO = findAllCustomersUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK).body(customerResponseDTO);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<CustomerResponseDTO> findCustomerById(@PathVariable @NotNull UUID id) {
        CustomerResponseDTO customerResponseDTO = findCustomerByIDUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(customerResponseDTO);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<CustomerResponseDTO> findByCpf(@PathVariable @NotNull @CPF String cpf) {
        CustomerResponseDTO customerResponseDTO = findCustomerByCPFUseCase.execute(cpf);
        return ResponseEntity.status(HttpStatus.OK).body(customerResponseDTO);
    }
}
