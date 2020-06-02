package com.mokhovav.base_spring_boot_project.exceptions;

import org.springframework.stereotype.Component;

@Component
public class LogicalException extends Exception{
    public LogicalException() {
    }
    public LogicalException(String message) {
        super(message);
    }
}
