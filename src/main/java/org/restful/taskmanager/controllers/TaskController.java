package org.restful.taskmanager.controllers;

import org.restful.taskmanager.models.Task;
import org.restful.taskmanager.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public Task GetTaskById(@PathVariable Long id){
        return taskService.findById(id);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskService.save(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task taskDetails){
        Task task = taskService.findById(id);
        if (task!=null){
            task.setName(taskDetails.getName());
            task.setDescription(taskDetails.getDescription());
            task.setStartDate(taskDetails.getStartDate());
            task.setEndDate(taskDetails.getEndDate());
            task.setStatus(taskDetails.getStatus());
            return taskService.save(task);
        }
        return null;
    }

    @GetMapping("/user/{userId}")
    public List<Task> getTaskByUserId(@PathVariable Long userId){
        return taskService.findByUserId(userId);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteById(id);
    }
}
