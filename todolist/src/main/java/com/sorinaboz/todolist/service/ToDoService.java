package com.sorinaboz.todolist.service;

import com.sorinaboz.todolist.model.ToDo;
import com.sorinaboz.todolist.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ToDoService {
    @Autowired
    private ToDoRepository toDoRepository;

    public List<ToDo> getAllToDos() {
        List<ToDo> toDos = new ArrayList<>();
        toDoRepository.findAll().forEach(toDos::add);
        return toDos;
    }

    public ToDo getToDo(int id) {
        return toDoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Todo id: " + id + " not found"));
    }

    public void addToDo(ToDo toDo) {
        toDoRepository.save(toDo);
    }

    public void updateToDo(int id, ToDo toDo) {
        toDoRepository.save(toDo);
    }

    public void deleteToDo(int id) {
        toDoRepository.deleteById(id);
    }
}

