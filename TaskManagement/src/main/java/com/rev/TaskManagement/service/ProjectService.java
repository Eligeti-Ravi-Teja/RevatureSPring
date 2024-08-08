package com.rev.TaskManagement.service;

import com.rev.TaskManagement.dao.ProjectRepo;
import com.rev.TaskManagement.model.Project;
import com.rev.TaskManagement.model.Task;
import com.rev.TaskManagement.utilities.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    ProjectRepo projectRepo;

    public ResponseEntity<BaseResponse<Project>> createProject(Project project){
        BaseResponse<Project> br=new BaseResponse<>();
        br.setData(projectRepo.save(project));
        br.setMessage("Project created successfullly");
        br.setStatus(HttpStatus.CREATED.value());
        return new ResponseEntity<>(br,HttpStatus.CREATED);
    }


    public ResponseEntity<BaseResponse<List<Project>>> fetchProjects(){
        BaseResponse<List<Project>> br=new BaseResponse<>();
        br.setData(projectRepo.findAll());
        br.setMessage("Project created successfullly");
        br.setStatus(HttpStatus.CREATED.value());
        return new ResponseEntity<>(br,HttpStatus.CREATED);
    }

    public ResponseEntity<BaseResponse<Project>> getProjectById(int id){
        BaseResponse<Project> br=new BaseResponse<>();
        br.setData(projectRepo.findById(id).get());
        br.setMessage("Project created successfullly");
        br.setStatus(HttpStatus.CREATED.value());
        return new ResponseEntity<>(br,HttpStatus.CREATED);
    }

    public ResponseEntity<BaseResponse<Project>> updateProject(Project project){
        BaseResponse<Project> br=new BaseResponse<>();
        br.setData(projectRepo.save(project));
        br.setMessage("Project updated successfullly");
        br.setStatus(HttpStatus.CREATED.value());
        return new ResponseEntity<>(br,HttpStatus.CREATED);
    }

    public ResponseEntity<BaseResponse<Project>> deleteProject(int id){
        Project project=projectRepo.findById(id).get();
        projectRepo.deleteById(id);
        BaseResponse<Project> br=new BaseResponse<>();
        br.setData(project);
        br.setMessage("Project deleted successfullly");
        br.setStatus(HttpStatus.CREATED.value());
        return new ResponseEntity<>(br,HttpStatus.CREATED);
    }

    public ResponseEntity<BaseResponse<List<Task>>> getProjectTasks(int id){
        BaseResponse<List<Task>> tasks=new BaseResponse<>();
        tasks.setData(projectRepo.findById(id).get().getTasks());
        tasks.setMessage("Fetched all project tasks");
        tasks.setStatus(HttpStatus.OK.value());
        return new ResponseEntity<>(tasks,HttpStatus.OK);
    }


}
