package ru.gb.SpringHome8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.SpringHome8.aspects.TrackUserAction;
import ru.gb.SpringHome8.model.Task;
import ru.gb.SpringHome8.model.TaskStatus;
import ru.gb.SpringHome8.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository repository;
    @TrackUserAction(mapping = "GET")
    public List<Task> getAllTasks(){
        return repository.findAll();
    }
    @TrackUserAction(mapping = "POST")
    public Task createTask(Task task){
        return repository.save(task);
    }
    @TrackUserAction(mapping = "GET")
    public List<Task> getTasksByStatus(TaskStatus status){
        return repository.findByStatus(status);
    }
    @TrackUserAction(mapping = "PUT")
    public Task updateTaskStatus(Long id, Task taskDetails){
        Optional<Task> optionalTask = repository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setDescription(taskDetails.getDescription());
            task.setStatus(taskDetails.getStatus());
            task.setCreateTime(taskDetails.getCreateTime());
            return repository.save(task);
        } else {
            throw new IllegalArgumentException("Task not found with id: " + id);
        }
    }
    @TrackUserAction(mapping = "DELETE")
    public void deleteTask(Long id){
        repository.deleteById(id);
    }

}
