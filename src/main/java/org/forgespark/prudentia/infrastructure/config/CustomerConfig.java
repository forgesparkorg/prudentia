package org.forgespark.prudentia.infrastructure.config;

import org.forgespark.prudentia.application.mappers.CustomerDTOMapper;
import org.forgespark.prudentia.application.ports.CustomerRepository;
import org.forgespark.prudentia.application.usecases.customer.*;
import org.forgespark.prudentia.infrastructure.adapters.CustomerRepositoryImpl;
import org.forgespark.prudentia.infrastructure.persistence.mappers.CustomerEntityMapper;
import org.forgespark.prudentia.infrastructure.persistence.repositories.JpaCustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    @Bean
    CreateCustomerUseCase createCustomerUserCase(CustomerRepository customerRepository,
                                                 CustomerDTOMapper customerDTOMapper) {
        return new CreateCustomerUseCase(customerRepository, customerDTOMapper);
    }

    @Bean
    FindCustomerByIDUseCase findByIDUseCase(CustomerRepository customerRepository,
                                            CustomerDTOMapper customerDTOMapper) {
        return new FindCustomerByIDUseCase(customerRepository, customerDTOMapper);
    }

    @Bean
    FindAllCustomersUseCase findAllCustomersUserCase(CustomerRepository customerRepository,
                                                     CustomerDTOMapper customerDTOMapper) {
        return new FindAllCustomersUseCase(customerRepository, customerDTOMapper);
    }

    @Bean
    FindCustomerByCPFUseCase findByCPFUseCase(CustomerRepository customerRepository,
                                              CustomerDTOMapper customerDTOMapper) {
        return new FindCustomerByCPFUseCase(customerRepository, customerDTOMapper);
    }

    @Bean
    UpdateCustomerUseCase updateCustomerUseCase(CustomerRepository customerRepository,
                                                CustomerDTOMapper customerDTOMapper) {
        return new UpdateCustomerUseCase(customerRepository, customerDTOMapper);
    }

    @Bean
    DeleteCustomerUseCase deleteCustomerUseCase(CustomerRepository customerRepository) {
        return new DeleteCustomerUseCase(customerRepository);
    }

    @Bean
    CustomerRepositoryImpl customerRepositoryImpl(JpaCustomerRepository jpaCustomerRepository,
                                                  CustomerEntityMapper customerEntityMapper) {
        return new CustomerRepositoryImpl(jpaCustomerRepository, customerEntityMapper);
    }

    @Bean
    CustomerDTOMapper customerDTOMapper() {
        return new CustomerDTOMapper();
    }

    @Bean
    CustomerEntityMapper customerMapper() {
        return new CustomerEntityMapper();
    }
}
