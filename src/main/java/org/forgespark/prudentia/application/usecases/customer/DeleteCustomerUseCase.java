package org.forgespark.prudentia.application.usecases.customer;

import lombok.AllArgsConstructor;
import org.forgespark.prudentia.application.ports.CustomerRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@AllArgsConstructor
public class DeleteCustomerUseCase {

    private final CustomerRepository repository;

    @Transactional
    public void execute(UUID id) {
        if (isCustomerExists(id)) {
            repository.deleteCustomer(id);
        }
    }

    @Transactional(readOnly = true)
    protected boolean isCustomerExists(UUID id) {
        return repository.isCustomerExists(id);
    }
}
