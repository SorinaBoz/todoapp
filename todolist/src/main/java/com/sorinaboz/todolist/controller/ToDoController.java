package com.sorinaboz.todolist.controller;

import com.sorinaboz.todolist.model.ToDo;
import com.sorinaboz.todolist.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @GetMapping("/index")
    public String showHomePage(){
        return "index";
    }

    @RequestMapping("/todos")
    public String getAllToDos(Model model) {
        List<ToDo> toDos = toDoService.getAllToDos();
        model.addAttribute("todos", toDos);
        return "todos";
    }

    @RequestMapping("/todos/{id}")
    public ToDo getToDo(@PathVariable int id) {
        return toDoService.getToDo(id);
    }


    @GetMapping( "/addtodo")
    public String addToDo(Model model) {
        model.addAttribute("todo", new ToDo());
        return "addtodo";
    }
    @PostMapping("/createToDo")
    public String createToDo(@ModelAttribute ToDo toDo, Model model) {
        model.addAttribute("todo", toDo);
        toDoService.addToDo(toDo);
        return "redirect:todos";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        ToDo toDo = toDoService.getToDo(id);
        model.addAttribute("todo", toDo);
        return "update";
    }

    @GetMapping("/delete/{id}")
    public String deleteToDo(@PathVariable (value = "id") int id, Model model) {
        toDoService.deleteToDo(id);
        return getAllToDos(model);
    }
}
