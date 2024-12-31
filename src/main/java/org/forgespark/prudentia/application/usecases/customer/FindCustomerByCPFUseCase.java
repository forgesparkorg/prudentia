package org.forgespark.prudentia.application.usecases.customer;

import lombok.AllArgsConstructor;
import org.forgespark.prudentia.application.dtos.customer.CustomerResponseDTO;
import org.forgespark.prudentia.application.mappers.CustomerDTOMapper;
import org.forgespark.prudentia.application.ports.CustomerRepository;
import org.forgespark.prudentia.domain.entities.Customer;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
public class FindCustomerByCPFUseCase {

    private final CustomerRepository repository;
    private final CustomerDTOMapper customerDTOMapper;

    @Transactional(readOnly = true)
    public CustomerResponseDTO execute(String cpf) {
        Customer customer = repository.findByCPF(cpf);
        return customerDTOMapper.toResponseDTO(customer);
    }
}
