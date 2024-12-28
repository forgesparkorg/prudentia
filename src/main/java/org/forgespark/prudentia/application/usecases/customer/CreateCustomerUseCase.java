package org.forgespark.prudentia.application.usecases.customer;

import lombok.AllArgsConstructor;
import org.forgespark.prudentia.application.dtos.CustomerDTO;
import org.forgespark.prudentia.application.mappers.CustomerDTOMapper;
import org.forgespark.prudentia.application.ports.CustomerRepository;
import org.forgespark.prudentia.domain.entities.Customer;

@AllArgsConstructor
public class CreateCustomerUseCase {

    private final CustomerRepository repository;

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = CustomerDTOMapper.toDomain(customerDTO);
        Customer createdCustomer = repository.saveCustomer(customer);
        return CustomerDTOMapper.toDTO(createdCustomer);
    }
}
