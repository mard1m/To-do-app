package opnu.ua.todoapp.controller;

import opnu.ua.todoapp.model.ToDoItem;
import opnu.ua.todoapp.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/todo")
public class ToDoRestController {

    @Autowired
    private ToDoRepository repository;

    @GetMapping("/all")
    public @ResponseBody Iterable<ToDoItem> getAll() {
        Iterable<ToDoItem> todoList = repository.findAll();
        return repository.findAll();
    }

    @PostMapping("/add")
    public @ResponseBody Result addItem(@RequestParam String name, @RequestParam String category) {
        ToDoItem item = new ToDoItem(category, name);
        ToDoItem saved = repository.save(item);
        return new Result("Added", saved);
    }
    @PostMapping("/update")
    public @ResponseBody Result updateItem(@RequestParam long id, @RequestParam String name,
                                           @RequestParam String category, @RequestParam boolean isComplete) {
        ToDoItem item = new ToDoItem(category, name);
        item.setId(id);
        item.setComplete(isComplete);
        ToDoItem saved = repository.save(item);
        return new Result("Updated", saved);
    }

    class Result {
        private String status;
        private ToDoItem item;

        public Result() {
            status = "";
            item = null;
        }
        public Result(String status, ToDoItem item) {
            this.status = status;
            this.item = item;
        }

        public ToDoItem getItem() {
            return item;
        }
        public void setItem(ToDoItem item) {
            this.item = item;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

}
