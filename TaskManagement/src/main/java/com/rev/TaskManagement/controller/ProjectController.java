package com.rev.TaskManagement.controller;

import com.rev.TaskManagement.model.Project;
import com.rev.TaskManagement.model.Task;
import com.rev.TaskManagement.service.ProjectService;
import com.rev.TaskManagement.utilities.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @PostMapping
    public ResponseEntity<BaseResponse<Project>> createProject(@RequestBody Project project){
        return projectService.createProject(project);
    }

    @GetMapping
    public ResponseEntity<BaseResponse<List<Project>>> fetchAllProjects(){
        return projectService.fetchProjects();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<Project>> fetchProjectById(@PathVariable int id){
        return projectService.getProjectById(id);
    }

    @PutMapping
    public ResponseEntity<BaseResponse<Project>> updateProject(@RequestBody Project project){
        return projectService.updateProject(project);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<Project>> deletProject(@PathVariable int id){
        return projectService.deleteProject(id);
    }

    @GetMapping("/projectTasks/{id}")
    public  ResponseEntity<BaseResponse<List<Task>>> fetchProjectTasks(@PathVariable int id){
        return projectService.getProjectTasks(id);
    }

}
