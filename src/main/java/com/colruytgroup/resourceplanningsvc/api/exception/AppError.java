package com.colruytgroup.resourceplanningsvc.api.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
public class AppError {
    private HttpStatus status;
    private String message;

    //private List<String> errors;

}
