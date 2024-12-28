package org.forgespark.prudentia.application.ports;

import org.forgespark.prudentia.domain.entities.Customer;

import java.util.List;

public interface CustomerRepository {
    Customer saveCustomer(Customer customer);

    List<Customer> findAllCustomers();
}
