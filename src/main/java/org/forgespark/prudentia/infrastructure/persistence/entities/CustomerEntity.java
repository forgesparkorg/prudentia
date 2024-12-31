package org.forgespark.prudentia.infrastructure.persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder(toBuilder = true)
@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private OffsetDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private OffsetDateTime updatedAt;

    @Column(name = "name", nullable = false)
    @Size(max = 100, message = "Name is invalid: must have 100 characters")
    private String name;

    @Column(name = "last_name")
    @Size(max = 120, message = "Last name must have at most 120 characters")
    private String lastName;

    @Column(name = "cpf", nullable = false, unique = true)
    @CPF(message = "Must be a valid CPF")
    private String cpf;

    @Column(name = "birth_date", nullable = false)
    @Past(message = "Birth date must be in the past")
    private LocalDate birthDate;

    @Column(name = "email", nullable = false, unique = true)
    @Email(message = "Must be a valid email")
    private String email;

    @Column(name = "phone", nullable = false)
    @Size(max = 15, message = "Phone must have at most 15 characters")
    private String phone;
}
