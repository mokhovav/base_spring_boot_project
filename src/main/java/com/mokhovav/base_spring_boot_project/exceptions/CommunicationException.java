package com.mokhovav.base_spring_boot_project.exceptions;

import org.springframework.stereotype.Component;

@Component
public class CommunicationException extends Exception {
    public CommunicationException() {
    }

    public CommunicationException(String message) {
        super(message);
    }
}
