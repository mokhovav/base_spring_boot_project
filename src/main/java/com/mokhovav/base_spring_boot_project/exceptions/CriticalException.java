package com.mokhovav.base_spring_boot_project.exceptions;

import org.springframework.stereotype.Component;

@Component
public class CriticalException extends Exception{
    public CriticalException() {
    }
    public CriticalException(String message) {
        super(message);
    }
}
