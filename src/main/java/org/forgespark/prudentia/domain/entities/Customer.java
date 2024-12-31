package org.forgespark.prudentia.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.forgespark.prudentia.domain.valueobjects.Address;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Getter
@AllArgsConstructor
public class Customer {
    private UUID id;
    private String name;
    private String lastName;
    private String cpf;
    private LocalDate birthDate;
    private String email;
    private String phone;
    private Address address;
}
