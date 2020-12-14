package com.javasneo.todolist.controller;

import com.javasneo.todolist.model.Todo;
import com.javasneo.todolist.model.TodoListResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by Abderrahmen on 31/01/2018.
 */
@RestController
@RequestMapping("/todos")
@CrossOrigin()
public class TodoController {

  ArrayList<Todo> todos;

  static int id = 0;

  public TodoController(){
    this.todos = new ArrayList<>();
    this.todos.add(new Todo(id++,"my first todo","my first todo description"));
    this.todos.add(new Todo(id++, "my second todo","my second todo description"));
    this.todos.add(new Todo(id++, "my third todo","my third todo description"));

  }

  @RequestMapping(method = RequestMethod.GET)
  public TodoListResponse todos (){
    TodoListResponse todoListResponse = new TodoListResponse();
    todoListResponse.setTodos(this.todos);

    return todoListResponse;
  }

  @RequestMapping(method = RequestMethod.POST)
  public Todo addtodo (@RequestBody Todo todo){
    todo.setId(++id);
    this.todos.add(todo);
    return todo;
  }


  @RequestMapping(method = RequestMethod.PUT)
  public Todo updateTodo (@RequestBody Todo todo){

    for(int i =0; i < this.todos.size(); i++){

      if(this.todos.get(i).getId()  == todo.getId()){
        this.todos.get(i).setName(todo.getName());
        this.todos.get(i).setDescription(todo.getDescription());
        break;
      }
    }
    return todo;
  }

  @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
  public void deleteTodo (@PathVariable("id") int id){

    for(int i =0; i < this.todos.size(); i++){

      if(this.todos.get(i).getId()  == id){
        this.todos.remove(i);
        break;
      }
    }
  }

}
