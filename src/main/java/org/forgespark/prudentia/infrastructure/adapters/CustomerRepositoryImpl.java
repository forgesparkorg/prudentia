package org.forgespark.prudentia.infrastructure.adapters;

import lombok.AllArgsConstructor;
import org.forgespark.prudentia.application.ports.CustomerRepository;
import org.forgespark.prudentia.domain.entities.Customer;
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
        CustomerEntity entity = mapper.toEntity(customer);
        repository.save(entity);
        CustomerEntity customerEntity = mapper.toEntity(findByCPF(customer.getCpf()));
        return mapper.toDomain(customerEntity);
    }

    @Override
    public Customer findById(UUID id) {
        return repository.findById(id)
                .map(mapper::toDomain)
                .orElse(null);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Customer findByCPF(String cpf) {
        CustomerEntity customerEntity = repository.findByCpf(cpf);
        return mapper.toDomain(customerEntity);
    }
}
