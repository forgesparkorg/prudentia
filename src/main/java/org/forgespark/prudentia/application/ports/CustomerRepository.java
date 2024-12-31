package org.forgespark.prudentia.application.ports;

import org.forgespark.prudentia.domain.entities.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerRepository {
    Customer saveCustomer(Customer customer);

    Customer findById(UUID id);

    List<Customer> findAllCustomers();

    Customer findByCPF(String cpf);
}
