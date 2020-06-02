package com.mokhovav.base_spring_boot_project.exceptions;


import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(annotations = RestController.class)
public class RESTExceptionController {
    private final ExceptionService exceptionService;
    private final Logger logger;

    public RESTExceptionController(ExceptionService exceptionService, Logger logger) {
        this.exceptionService = exceptionService;
        this.logger = logger;
    }

    @ExceptionHandler(ValidException.class)
    private ResponseEntity<ErrorResponse> validException(Exception exception, HttpServletRequest request){
        logger.debug(String.format("%-16s","VALID ERROR:") + exception.getMessage());
        return exceptionService.getRESTMessage(exception, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(LogicalException.class)
    private ResponseEntity<ErrorResponse> logicalException(Exception exception, HttpServletRequest request){
        logger.debug(String.format("%-16s","LOGICAL ERROR:") + exception.getMessage());
        return exceptionService.getRESTMessage(exception, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(CriticalException.class)
    private ResponseEntity<ErrorResponse> criticalException(Exception exception, HttpServletRequest request){
        logger.error(String.format("%-16s","CRITICAL ERROR:") + exceptionService.getLoggerMessage(request, exception));
        return exceptionService.getRESTMessage(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<ErrorResponse> exception(Exception exception, HttpServletRequest request){
        logger.error(String.format("%-16s","UNKNOWN ERROR:") + exceptionService.getLoggerMessage(request, exception));
        return exceptionService.getRESTMessage(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
