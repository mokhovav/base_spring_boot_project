package com.mokhovav.base_spring_boot_project.baseClasses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@MappedSuperclass
public class BaseEntity {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    protected String name;

    public Long getId() {
        return id;
    }

    public boolean isNew() {
        return this.id == null;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
