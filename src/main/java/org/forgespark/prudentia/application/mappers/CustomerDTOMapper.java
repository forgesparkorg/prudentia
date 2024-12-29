package org.forgespark.prudentia.application.mappers;

import org.forgespark.prudentia.application.dtos.CustomerDTO;
import org.forgespark.prudentia.domain.entities.Customer;

public class CustomerDTOMapper {
    public Customer toDomain(CustomerDTO customerDTO) {
        return Customer.builder()
                .name(customerDTO.getName())
                .lastName(customerDTO.getLastName())
                .cpf(customerDTO.getCpf())
                .birthDate(customerDTO.getBirthDate())
                .email(customerDTO.getEmail())
                .phone(customerDTO.getPhone())
                .build();
    }

    public CustomerDTO toDTO(Customer customer) {
        return CustomerDTO.builder()
                .name(customer.getName())
                .lastName(customer.getLastName())
                .cpf(customer.getCpf())
                .birthDate(customer.getBirthDate())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .build();
    }
}
