package opnu.ua.todoapp.controller;

import opnu.ua.todoapp.model.ToDoItem;
import opnu.ua.todoapp.model.ToDoListViewModel;
import opnu.ua.todoapp.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ToDoController {

    @Autowired
    private ToDoRepository repository;

    @GetMapping("/")
    public String index(Model model) {
        Iterable<ToDoItem> todoList = repository.findAll();
        model.addAttribute("items", new ToDoListViewModel(todoList));
        model.addAttribute("newitem", new ToDoItem());
        return "index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute ToDoItem requestItem) {
        ToDoItem item = new ToDoItem(requestItem.getDescription(),requestItem.getName());
        repository.save(item);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute ToDoListViewModel requestItems) {
        for (ToDoItem requestItem : requestItems.getTodoList() ) {
            ToDoItem item = new ToDoItem(requestItem.getDescription(), requestItem.getName());
            item.setComplete(requestItem.isComplete());
            item.setId(requestItem.getId());
            repository.save(item);
        }
        return "redirect:/";
    }
}
