package com.rev.TaskManagement.controller;

import com.rev.TaskManagement.model.Task;
import com.rev.TaskManagement.service.TaskService;
import com.rev.TaskManagement.utilities.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @PostMapping
    public ResponseEntity<BaseResponse<Task>> createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

    @GetMapping
    public ResponseEntity<BaseResponse<List<Task>>> fetchAllTasks(){
        return taskService.fetchAllTasks();
    }

    @PutMapping
    public ResponseEntity<BaseResponse<Task>> updateTask(@RequestBody Task task){
        return taskService.updateTask(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<Task>> deleteTask(@PathVariable long id){
        return taskService.deleteTask(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<Task>> getTaskById(@PathVariable long id){
        return taskService.fetchTaskById(id);
    }


}