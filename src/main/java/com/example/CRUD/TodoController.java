package com.example.CRUD;

import com.example.CRUD.models.Todo;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
//@Slf4j
public class TodoController {

    @Autowired
    private TodoService todoService;

    // Create Elements Into H2 Database

    @PostMapping("/create")
    ResponseEntity<Todo> createUser(@RequestBody Todo todo){
        return new ResponseEntity<>(todoService.createTodo(todo), HttpStatus.CREATED);
    }

    //  find Element By Id

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Todo Retrieved Successfully"),
            @ApiResponse(responseCode = "404", description = "Todo Was not found!.")
    })

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable long id) {
        try {
            Todo todo = todoService.getTodoById(id);
            return new ResponseEntity<>(todo, HttpStatus.OK);
        } catch (RuntimeException exception) {
//            log.info("Error");
//            log.warn("");
//            log.error("");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }
    }

    //     Get All Elements from H2 DB

    @GetMapping
    ResponseEntity<List<Todo>> getTodo(){
        return new ResponseEntity<List<Todo>>(todoService.getTodos(), HttpStatus.OK);
    }

    // Update to the data from DB

    @PutMapping
    ResponseEntity<Todo> updateTodoById(@RequestBody Todo todo){
        return new ResponseEntity<>(todoService.updateTodo(todo), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteTodoById(@PathVariable Long id){
        todoService.deleteTodoById(id);
    }

    //Pageable

    @GetMapping("/page")
    ResponseEntity<Page<Todo>> getAllTodosPaged(@RequestParam int page, int size){
        return new ResponseEntity<>(todoService.getAllTodoPages(page, size), HttpStatus.OK);

    }

    @GetMapping("/get")
    public String firstpro(){
        return "it html page";
    }

}
