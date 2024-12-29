package org.forgespark.prudentia.infrastructure.config;

import org.forgespark.prudentia.application.mappers.CustomerDTOMapper;
import org.forgespark.prudentia.application.ports.CustomerRepository;
import org.forgespark.prudentia.application.usecases.customer.CreateCustomerUseCase;
import org.forgespark.prudentia.application.usecases.customer.FindAllCustomersUseCase;
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
    FindAllCustomersUseCase findAllCustomersUserCase(CustomerRepository customerRepository,
                                                     CustomerDTOMapper customerDTOMapper) {
        return new FindAllCustomersUseCase(customerRepository, customerDTOMapper);
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
