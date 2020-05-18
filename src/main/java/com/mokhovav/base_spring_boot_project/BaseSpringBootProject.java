package com.mokhovav.base_spring_boot_project;

import com.mokhovav.base_spring_boot_project.annotations.Tracking;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BaseSpringBootProject {
    @Tracking
    public static void main(String[] args) {
        SpringApplication.run(BaseSpringBootProject.class, args);
    }
}