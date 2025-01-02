package org.forgespark.prudentia.application.exceptions.customer;

public class CustomerValidationException extends RuntimeException {
    public CustomerValidationException(String message) {
        super(message);
    }
}
