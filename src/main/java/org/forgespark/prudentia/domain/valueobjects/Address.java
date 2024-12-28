package org.forgespark.prudentia.domain.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class Address {
    private String street;
    private String number;
    private String city;
    private String state;
    private String zipCode;
}
