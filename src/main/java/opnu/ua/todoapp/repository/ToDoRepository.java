package opnu.ua.todoapp.repository;

import opnu.ua.todoapp.model.ToDoItem;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDoItem, Long> {

}
