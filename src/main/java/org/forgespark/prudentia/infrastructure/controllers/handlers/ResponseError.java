package org.forgespark.prudentia.infrastructure.controllers.handlers;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

@Builder
@Getter
public class ResponseError {
    private String message;
    private HttpStatus status;
    private LocalDateTime timestamp;
    private Map<String, String> details;
}
