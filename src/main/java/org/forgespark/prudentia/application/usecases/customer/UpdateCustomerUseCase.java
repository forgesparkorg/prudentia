package org.forgespark.prudentia.application.usecases.customer;

import lombok.AllArgsConstructor;
import org.forgespark.prudentia.application.dtos.customer.CustomerDTO;
import org.forgespark.prudentia.application.exceptions.customer.CustomerNotFoundException;
import org.forgespark.prudentia.application.exceptions.customer.CustomerValidationException;
import org.forgespark.prudentia.application.mappers.CustomerDTOMapper;
import org.forgespark.prudentia.application.ports.CustomerRepository;
import org.forgespark.prudentia.domain.entities.Customer;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@AllArgsConstructor
public class UpdateCustomerUseCase {

    private final CustomerRepository repository;
    private final CustomerDTOMapper customerDTOMapper;

    @Transactional
    public CustomerDTO execute(UUID id, CustomerDTO customerDTO) {
        validateCustomer(id, customerDTO);

        Customer customer = customerDTOMapper.toDomain(customerDTO);
        Customer updatedCustomer = repository.saveCustomer(customer);
        return customerDTOMapper.toResponseDTO(updatedCustomer);
    }

    private void validateCustomer(UUID id, CustomerDTO customerDTO) {
        if (!id.equals(customerDTO.getId())) {
            throw new CustomerValidationException("Customer ID does not match");
        }
        if (!repository.isCustomerExists(id)) {
            throw new CustomerNotFoundException("Customer does not exist", id.toString());
        }
    }
}
