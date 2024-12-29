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
    CreateCustomerUseCase createCustomerUserCase(CustomerRepository repository, CustomerDTOMapper mapper) {
        return new CreateCustomerUseCase(repository, mapper);
    }

    @Bean
    FindAllCustomersUseCase findAllCustomersUserCase(CustomerRepository repository, CustomerDTOMapper mapper) {
        return new FindAllCustomersUseCase(repository, mapper);
    }

    @Bean
    CustomerRepositoryImpl customerRepositoryImpl(JpaCustomerRepository jpaRepository, CustomerEntityMapper mapper) {
        return new CustomerRepositoryImpl(jpaRepository, mapper);
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
