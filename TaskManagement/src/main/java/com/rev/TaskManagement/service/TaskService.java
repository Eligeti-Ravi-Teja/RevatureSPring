package com.rev.TaskManagement.service;

import com.rev.TaskManagement.dao.TaskRepo;
import com.rev.TaskManagement.model.Task;
import com.rev.TaskManagement.utilities.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    TaskRepo taskDao;
    public ResponseEntity<BaseResponse<Task>> createTask(Task task){
        Task dbtask=taskDao.save(task);
        BaseResponse<Task> rs=new BaseResponse<>();
        rs.setData(taskDao.save(task));
        rs.setMessage("Task added successfully");
        rs.setStatus(HttpStatus.CREATED.value());
        return new ResponseEntity<>(rs,HttpStatus.CREATED);
    }

    public ResponseEntity<BaseResponse<List<Task>>> fetchAllTasks(){
        BaseResponse<List<Task>> rs=new BaseResponse<>();
        rs.setData(taskDao.findAll());
        rs.setMessage("Tasks fetched successfully");
        rs.setStatus(HttpStatus.CREATED.value());
        return new ResponseEntity<>(rs,HttpStatus.OK);
    }

    public ResponseEntity<BaseResponse<Task>> fetchTaskById(long id){
        BaseResponse<Task> br=new BaseResponse<>();
        br.setData(taskDao.findById(id).get());
        br.setMessage("Fetched task successfully");
        br.setStatus(HttpStatus.OK.value());
        return new ResponseEntity<>(br,HttpStatus.OK);
    }

    public ResponseEntity<BaseResponse<Task>> updateTask(Task task){
        BaseResponse<Task> br=new BaseResponse<>();
        br.setStatus(HttpStatus.OK.value());
        br.setData(taskDao.save(task));
        br.setMessage("Task update successfull");
        return new ResponseEntity<>(br,HttpStatus.OK);
    }

    public ResponseEntity<BaseResponse<Task>> deleteTask(long id){
        Task task=taskDao.findById(id).get();
        taskDao.deleteById(id);
        BaseResponse<Task> br=new BaseResponse<>();
        br.setMessage("Task has been deleted successfully");
        br.setData(task);
        br.setStatus(HttpStatus.OK.value());
        return new ResponseEntity<>(br,HttpStatus.OK);
    }
}
