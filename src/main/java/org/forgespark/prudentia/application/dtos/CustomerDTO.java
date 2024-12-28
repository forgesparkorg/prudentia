package org.forgespark.prudentia.application.dtos;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class CustomerDTO {
    private String name;
    private String cpf;
    private LocalDate birthDate;
    private String email;
    private String phone;
}
