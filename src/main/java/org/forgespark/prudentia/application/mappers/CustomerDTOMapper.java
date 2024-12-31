package org.forgespark.prudentia.application.mappers;

import org.forgespark.prudentia.application.dtos.customer.CustomerCreateDTO;
import org.forgespark.prudentia.application.dtos.customer.CustomerResponseDTO;
import org.forgespark.prudentia.domain.entities.Customer;

public class CustomerDTOMapper {
    public Customer toDomain(CustomerCreateDTO dto) {
        return Customer.builder()
                .name(dto.getName())
                .lastName(dto.getLastName())
                .cpf(dto.getCpf())
                .birthDate(dto.getBirthDate())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .build();
    }

    public Customer toDomain(CustomerResponseDTO dto) {
        return Customer.builder()
                .id(dto.getId())
                .name(dto.getName())
                .lastName(dto.getLastName())
                .cpf(dto.getCpf())
                .birthDate(dto.getBirthDate())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .build();
    }

    public CustomerResponseDTO toResponseDTO(Customer domain) {
        return CustomerResponseDTO.builder()
                .id(domain.getId())
                .name(domain.getName())
                .lastName(domain.getLastName())
                .cpf(domain.getCpf())
                .birthDate(domain.getBirthDate())
                .email(domain.getEmail())
                .phone(domain.getPhone())
                .build();
    }

    public CustomerCreateDTO toCreateDTO(Customer domain) {
        return CustomerCreateDTO.builder()
                .name(domain.getName())
                .lastName(domain.getLastName())
                .cpf(domain.getCpf())
                .birthDate(domain.getBirthDate())
                .email(domain.getEmail())
                .phone(domain.getPhone())
                .build();
    }
}
