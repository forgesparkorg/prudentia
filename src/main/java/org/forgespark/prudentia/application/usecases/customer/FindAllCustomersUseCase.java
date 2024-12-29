package org.forgespark.prudentia.application.usecases.customer;

import lombok.AllArgsConstructor;
import org.forgespark.prudentia.application.dtos.CustomerDTO;
import org.forgespark.prudentia.application.mappers.CustomerDTOMapper;
import org.forgespark.prudentia.application.ports.CustomerRepository;
import org.forgespark.prudentia.domain.entities.Customer;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
public class FindAllCustomersUseCase {

    private final CustomerRepository repository;
    private final CustomerDTOMapper customerDTOMapper;

    @Transactional(readOnly = true)
    public List<CustomerDTO> findAllCustomers() {
        List<Customer> customers = repository.findAllCustomers();
        return customers.stream()
                .map(customerDTOMapper::toDTO)
                .toList();
    }
}
