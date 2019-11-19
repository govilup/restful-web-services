package com.practice.rest.webservices.restfulwebservices.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ExceptionResponse {
    
    private LocalDateTime localDateTime;
    private String message;
    private String details;

}
