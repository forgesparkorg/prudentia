package org.forgespark.prudentia.application.exceptions.customer;

import lombok.Getter;

import java.util.Map;

@Getter
public class CustomerNotFoundException extends RuntimeException {
    private final Map<String, String> details;

    public CustomerNotFoundException(String message) {
        super(message);
        this.details = Map.of("description", message);
    }

    public CustomerNotFoundException(String message, String customerNotFound) {
        super(message);
        this.details = Map.of("description", message,
                "customerNotFound", customerNotFound);
    }
}
