package com.mokhovav.base_spring_boot_project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Enumeration;

@Service
public class ExceptionService {

    public String getLoggerMessage(HttpServletRequest req, Exception exception) {

        String result = exception.getMessage() +
                String.format("\n    %-30s%s","method:", req.getMethod())+
                String.format("\n    %-30s%s","request URL:", req.getRequestURL())+
                String.format("\n    %-30s%s","protocol:", req.getProtocol())+
                String.format("\n    %-30s%s","path info:", req.getPathInfo())+
                String.format("\n    %-30s%s","remote address:", req.getRemoteAddr())+
                String.format("\n    %-30s%s","remote user:", req.getRemoteUser());
        Enumeration enumeration = req.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String name = (String)enumeration.nextElement();
            String value = req.getHeader(name);
            result += String.format("\n    %-30s%s",name + ":", value);
        }
        return result;

    }

    public ModelAndView getModelAndView(Exception exception) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("errors/error");
        modelAndView.addObject("error", exception.getMessage());
        return modelAndView;
    }

    public ResponseEntity<ErrorResponse> getRESTMessage(Exception exception, HttpStatus status){
        ErrorResponse error = new ErrorResponse();
        error.setTimestamp(LocalDateTime.now());
        error.setError(exception.getMessage());
        error.setStatus(status.value());
        return new ResponseEntity<>(error,status);
    }
}
