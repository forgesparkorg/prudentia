package org.forgespark.prudentia.infrastructure.persistence.mappers;

import org.forgespark.prudentia.domain.entities.Customer;
import org.forgespark.prudentia.infrastructure.persistence.entities.CustomerEntity;

public class CustomerEntityMapper {

    public CustomerEntity toEntity(Customer customer) {
        return CustomerEntity.builder()
                .name(customer.getName())
                .lastName(customer.getLastName())
                .cpf(customer.getCpf())
                .birthDate(customer.getBirthDate())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .build();
    }

    public Customer toDomain(CustomerEntity customerEntity) {
        return Customer.builder()
                .name(customerEntity.getName())
                .lastName(customerEntity.getLastName())
                .cpf(customerEntity.getCpf())
                .birthDate(customerEntity.getBirthDate())
                .email(customerEntity.getEmail())
                .phone(customerEntity.getPhone())
                .build();
    }
}
