package com.example.todo;

import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.todo.TodoService;
import com.example.todo.Todo;


@RestController
public class TodoController{
    TodoService todoService = new TodoService();

    @GetMapping("/todos")
    public ArrayList<Todo> getTodos(){
        return todoService.getTodos();
    }

    @PostMapping("/todos")
    public Todo getTodos(@RequestBody Todo todo){
        return todoService.addTodo(todo);
    }

    @GetMapping("/todos/{id}")
    public Todo getTodoById(@PathVariable("id") int id){
        return todoService.getTodoById(id);
    }

    @PutMapping("/todos/{id}")
    public Todo updateTodo(@PathVariable("id") int id,@RequestBody Todo todo){
        return todoService.updateTodo(id,todo);
    }

    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable("id") int id){
        todoService.deleteTodo(id);
    }

}
