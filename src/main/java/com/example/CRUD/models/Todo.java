package com.example.CRUD.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue
    Long id;
    @NotBlank(message = "title is required..")
    String title;
    @NotBlank
    //@Size(min = 2 ,max =10)
    //@Pattern(regexp = "^[0-9]{10}$")
    //@Min(1)
    //@Max(10)
    String description;
    Boolean isCompleted;
    @Email
    String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }
}
