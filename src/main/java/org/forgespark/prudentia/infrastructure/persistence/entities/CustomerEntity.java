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

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder(toBuilder = true)
@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq_gen")
    @SequenceGenerator(name = "customer_seq_gen", sequenceName = "customer_seq", allocationSize = 1)
    private Long id;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private OffsetDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private OffsetDateTime updatedAt;

    @Size(max = 100, message = "Name is invalid: must have 100 characters")
    @Column(name = "name",
            nullable = false)
    private String name;

    @Column(name = "cpf",
            nullable = false,
            unique = true)
    @CPF(message = "Invalid CPF: must be a valid CPF")
    private String cpf;

    @Column(name = "birth_date",
            nullable = false)
    @Past(message = "Birth date must be in the past")
    private LocalDate birthDate;

    @Column(name = "email",
            nullable = false,
            unique = true)
    @Email(message = "Invalid email: must be a valid email")
    private String email;

    @Column(name = "phone",
            nullable = false)
    @Size(max = 15, message = "Phone is invalid: must have 15 digits")
    private String phone;
}
