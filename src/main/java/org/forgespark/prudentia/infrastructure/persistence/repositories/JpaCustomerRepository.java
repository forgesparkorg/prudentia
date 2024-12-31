package org.forgespark.prudentia.infrastructure.persistence.repositories;

import org.forgespark.prudentia.infrastructure.persistence.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface JpaCustomerRepository extends JpaRepository<CustomerEntity, UUID> {

    @Query("SELECT c FROM CustomerEntity c WHERE c.cpf = :cpf")
    CustomerEntity findByCpf(String cpf);

}
