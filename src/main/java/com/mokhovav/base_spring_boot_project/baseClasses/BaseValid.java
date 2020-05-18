package com.mokhovav.base_spring_boot_project.baseClasses;

import org.springframework.stereotype.Service;

@Service
public class BaseValid {
    public BaseValid() {
    }
    public boolean nullOrEmpty(String str){
        return str==null || str.isEmpty();
    }
}
