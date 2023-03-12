/*
 * You can use the following import statements
 * 
 * 
 * 
 */

package com.example.todo;

import com.example.todo.Todo;
import com.example.todo.TodoRepository;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.*;

import javax.validation.OverridesAttribute;

// Do not modify the below code

public class TodoService implements TodoRepository {

    private static HashMap<Integer, Todo> todoList = new HashMap<>();
    int uniqueTodoId =  6;

    public TodoService() {
        todoList.put(1, new Todo(1, "Watch Movie", "LOW", "TO DO"));
        todoList.put(2, new Todo(2, "Finish Project", "HIGH", "IN PROGRESS"));
        todoList.put(3, new Todo(3, "Buy Groceries", "MEDIUM", "TO DO"));
        todoList.put(4, new Todo(4, "Learning from NxtWave", "HIGH", "IN PROGRESS"));
        todoList.put(5, new Todo(5, "Go for a Run", "MEDIUM", "DONE"));

    }

    // Do not modify the above code

    // Write your code here
    @Override
    public ArrayList<Todo> getTodos(){
        Collection<Todo>todosCollection = todoList.values();
        ArrayList<Todo>todos = new ArrayList<>(todosCollection);
        return todos;
    }

    @Override
    public Todo getTodoById(int id){
        Todo todo = todoList.get(id);
        if(todo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return todo;
    }

    @Override
    public Todo addTodo(Todo todo){
        todo.setId(uniqueTodoId);
        todoList.put(uniqueTodoId,todo);
        uniqueTodoId+= 1;
        return todo;
    }

    @Override
    public Todo updateTodo(int id,Todo todo){
        Todo savedTodo = todoList.get(id);
        if(savedTodo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
         }

        if(todo.getTodo() != null){
            savedTodo.setTodo(todo.getTodo());
        }
        if(todo.getPriority() != null){
            savedTodo.setPriority(todo.getPriority());
        }
        if(todo.getStatus() != null){
            savedTodo.setStatus(todo.getStatus());
        }

        return savedTodo;
    }

    @Override
    public void deleteTodo(int id){
         Todo savedTodo = todoList.get(id);
         if(savedTodo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
         }else{
            todoList.remove(id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
         }
    }


    


}
