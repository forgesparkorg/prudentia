package org.forgespark.prudentia.application.usecases.customer;

import lombok.AllArgsConstructor;
import org.forgespark.prudentia.application.dtos.CustomerDTO;
import org.forgespark.prudentia.application.mappers.CustomerDTOMapper;
import org.forgespark.prudentia.application.ports.CustomerRepository;
import org.forgespark.prudentia.domain.entities.Customer;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
public class CreateCustomerUseCase {

    private final CustomerRepository repository;
    private final CustomerDTOMapper customerDTOMapper;

    @Transactional
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = customerDTOMapper.toDomain(customerDTO);
        Customer createdCustomer = repository.saveCustomer(customer);
        return customerDTOMapper.toDTO(createdCustomer);
    }
}
