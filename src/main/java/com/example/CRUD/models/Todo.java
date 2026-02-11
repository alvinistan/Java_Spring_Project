package com.example.CRUD.models;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.models.examples.Example;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue
    Long id;
    @NotBlank(message = "title is required..")
    @Schema(name = "title", example = "Must be started in Capital")
    String title;
    @NotBlank
    //@Size(min = 2 ,max =10)
    //@Pattern(regexp = "^[0-9]{10}$")
    //@Min(1)
    //@Max(10)
    String description;
    Boolean isCompleted;

}
