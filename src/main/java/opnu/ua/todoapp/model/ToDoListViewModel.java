package opnu.ua.todoapp.model;

import java.util.ArrayList;

public class ToDoListViewModel {

    private ArrayList<ToDoItem> todoList = new ArrayList<ToDoItem>();

    public ToDoListViewModel() {}

    public ToDoListViewModel(Iterable<ToDoItem> items) {
        items.forEach(todoList:: add);
    }

    public ToDoListViewModel(ArrayList<ToDoItem> todoList) {
        this.todoList = todoList;
    }

    public ArrayList<ToDoItem> getTodoList() {
        return todoList;
    }

    public void setTodoList(ArrayList<ToDoItem> todoList) {
        this.todoList = todoList;
    }
}
