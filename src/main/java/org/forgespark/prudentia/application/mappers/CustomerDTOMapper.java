package org.forgespark.prudentia.application.mappers;

import org.forgespark.prudentia.application.dtos.customer.CustomerCreateDTO;
import org.forgespark.prudentia.application.dtos.customer.CustomerDTO;
import org.forgespark.prudentia.domain.entities.Customer;

public class CustomerDTOMapper {
    public Customer toDomain(CustomerCreateDTO customerCreateDTO) {
        return Customer.builder()
                .name(customerCreateDTO.getName())
                .lastName(customerCreateDTO.getLastName())
                .cpf(customerCreateDTO.getCpf())
                .birthDate(customerCreateDTO.getBirthDate())
                .email(customerCreateDTO.getEmail())
                .phone(customerCreateDTO.getPhone())
                .build();
    }

    public Customer toDomain(CustomerDTO customerDTO) {
        return Customer.builder()
                .id(customerDTO.getId())
                .name(customerDTO.getName())
                .lastName(customerDTO.getLastName())
                .cpf(customerDTO.getCpf())
                .birthDate(customerDTO.getBirthDate())
                .email(customerDTO.getEmail())
                .phone(customerDTO.getPhone())
                .build();
    }

    public CustomerDTO toResponseDTO(Customer customerDomain) {
        return CustomerDTO.builder()
                .id(customerDomain.getId())
                .name(customerDomain.getName())
                .lastName(customerDomain.getLastName())
                .cpf(customerDomain.getCpf())
                .birthDate(customerDomain.getBirthDate())
                .email(customerDomain.getEmail())
                .phone(customerDomain.getPhone())
                .build();
    }

    public CustomerCreateDTO toCreateDTO(Customer customerDomain) {
        return CustomerCreateDTO.builder()
                .name(customerDomain.getName())
                .lastName(customerDomain.getLastName())
                .cpf(customerDomain.getCpf())
                .birthDate(customerDomain.getBirthDate())
                .email(customerDomain.getEmail())
                .phone(customerDomain.getPhone())
                .build();
    }
}
