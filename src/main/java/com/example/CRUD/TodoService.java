package com.example.CRUD;

import com.example.CRUD.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);

    }

    public Todo getTodoById(Long id){
        return todoRepository.findById(id).orElseThrow(() ->new RuntimeException("Not found"));
    }
}
