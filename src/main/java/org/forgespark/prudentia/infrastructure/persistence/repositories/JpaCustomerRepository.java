package org.forgespark.prudentia.infrastructure.persistence.repositories;

import org.forgespark.prudentia.infrastructure.persistence.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
