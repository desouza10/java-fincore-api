package com.gui.fincore.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResponseStatusException.class)
    public ApiError handleStatusException(
            ResponseStatusException ex,
            HttpServletRequest request
    ) {
        HttpStatus status = (HttpStatus) ex.getStatusCode();
        String message = ex.getReason();

        if(message != null && message.contains("\"")) {
            message = message.substring(
                    message.indexOf("\"") + 1,
                    message.lastIndexOf("\"")
            );
        }

        return new ApiError(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                message,
                request.getRequestURI()
        );
    }
}
