package ru.gb.SpringHome8.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.SpringHome8.model.Task;
import ru.gb.SpringHome8.model.TaskStatus;
import ru.gb.SpringHome8.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskService service;

    @PostMapping
    public Task addTask(@RequestBody Task task){
        return service.createTask(task);
    }
    @GetMapping
    public List<Task> getAllTasks(){
        return service.getAllTasks();
    }
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status){
        return service.getTasksByStatus(status);
    }
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task){
        return service.updateTaskStatus(id, task);
    }
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        service.deleteTask(id);
    }
}
