package com.mokhovav.base_spring_boot_project.exception;

import org.springframework.stereotype.Component;

@Component
public class ValidException extends Exception{
    public ValidException() {
    }

    public ValidException(String message) {
        super(message);
    }
}