package org.forgespark.prudentia.infrastructure.adapters;

import lombok.AllArgsConstructor;
import org.forgespark.prudentia.application.ports.CustomerRepository;
import org.forgespark.prudentia.domain.entities.Customer;
import org.forgespark.prudentia.infrastructure.persistence.entities.CustomerEntity;
import org.forgespark.prudentia.infrastructure.persistence.mappers.CustomerEntityMapper;
import org.forgespark.prudentia.infrastructure.persistence.repositories.JpaCustomerRepository;

import java.util.List;

@AllArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {

    private final JpaCustomerRepository repository;
    private final CustomerEntityMapper mapper;

    @Override
    public Customer saveCustomer(Customer customer) {
        CustomerEntity entity = mapper.toEntity(customer);
        repository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }
}
