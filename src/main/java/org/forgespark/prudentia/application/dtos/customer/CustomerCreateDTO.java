package org.forgespark.prudentia.application.dtos.customer;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Builder
@Getter
public class CustomerCreateDTO {
    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must have at most 100 characters")
    private String name;

    @NotBlank(message = "Last name is required")
    @Size(max = 120, message = "Last name must have at most 120 characters")
    private String lastName;

    @NotBlank(message = "CPF is required")
    @CPF(message = "Must be a valid CPF")
    private String cpf;

    @NotBlank(message = "Birth date is required")
    @Past(message = "Birth date must be in the past")
    private LocalDate birthDate;

    @NotBlank(message = "Email is required")
    @Email(message = "Must be a valid email")
    private String email;

    @NotBlank(message = "Phone is required")
    @Size(max = 15, message = "Phone must have at most 15 characters")
    @Pattern(regexp = "^\\+?[0-9\\-\\s]{8,15}$", message = "Phone must be a valid format")
    private String phone;
}
