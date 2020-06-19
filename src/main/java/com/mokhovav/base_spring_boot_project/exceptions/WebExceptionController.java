package com.mokhovav.base_spring_boot_project.exceptions;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(annotations = Controller.class)
public class WebExceptionController {
    private final Logger logger;
    private final ExceptionService exceptionService;

    public WebExceptionController(Logger logger, ExceptionService exceptionService) {
        this.logger = logger;
        this.exceptionService = exceptionService;
    }

    @ExceptionHandler(ValidException.class)
    private void validException(HttpServletRequest req, ValidException exception){
        logger.debug(String.format("%-16s","VALID ERROR:")+exception.getMessage());
        return;
    }

    @ExceptionHandler(CommunicationException.class)
    private void communicationException(HttpServletRequest req, CommunicationException exception){
        logger.debug(String.format("%-16s","COMMUNICATION ERROR:")+exception.getMessage());
        return;
    }

    @ExceptionHandler(LogicalException.class)
    private void logicalException(HttpServletRequest req, LogicalException exception){
        logger.debug(String.format("%-16s","LOGICAL ERROR:")+exception.getMessage());
        return;
    }

    @ExceptionHandler(CriticalException.class)
    private ModelAndView criticalException(HttpServletRequest req, CriticalException exception){
        logger.error(String.format("%-16s","CRITICAL ERROR:")+exceptionService.getLoggerMessage(req, exception));
        return exceptionService.getModelAndView(exception);
    }

    @ExceptionHandler(Exception.class)
    private ModelAndView exception(HttpServletRequest req, Exception exception){
        logger.error(String.format("%-16s","UNKNOWN ERROR:")+exceptionService.getLoggerMessage(req, exception));
        return exceptionService.getModelAndView(exception);
    }
}
