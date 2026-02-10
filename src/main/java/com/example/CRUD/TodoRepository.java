package com.example.CRUD;

import com.example.CRUD.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TodoRepository extends JpaRepository<Todo, Long> {


}
