package org.forgespark.prudentia.infrastructure.adapters;

import lombok.AllArgsConstructor;
import org.forgespark.prudentia.application.ports.CustomerRepository;
import org.forgespark.prudentia.domain.entities.Customer;
import org.forgespark.prudentia.infrastructure.exceptions.CustomerNotFoundException;
import org.forgespark.prudentia.infrastructure.persistence.entities.CustomerEntity;
import org.forgespark.prudentia.infrastructure.persistence.mappers.CustomerEntityMapper;
import org.forgespark.prudentia.infrastructure.persistence.repositories.JpaCustomerRepository;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {

    private final JpaCustomerRepository repository;
    private final CustomerEntityMapper mapper;

    @Override
    public Customer saveCustomer(Customer customer) {
        CustomerEntity customerEntity = mapper.toEntity(customer);
        CustomerEntity savedEntity = repository.save(customerEntity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Customer findById(UUID id) {
        return repository.findById(id)
                .map(mapper::toDomain)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID", id.toString()));
    }

    @Override
    public List<Customer> findAllCustomers() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Customer findByCPF(String cpf) {
        return repository.findByCpf(cpf)
                .map(mapper::toDomain)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with CPF", cpf));
    }
}
