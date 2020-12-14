package com.javasneo.todolist.model;

import java.util.ArrayList;

public class TodoListResponse {

  private ArrayList<Todo> todos;

  public ArrayList<Todo> getTodos() {
    return todos;
  }

  public void setTodos(ArrayList<Todo> todos) {
    this.todos = todos;
  }
}
