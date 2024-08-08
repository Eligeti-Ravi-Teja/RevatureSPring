package com.rev.TaskManagement.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int project_id;
    private String project_name;

    private String project_desc;
    @OneToMany(mappedBy = "task",cascade = CascadeType.ALL)
    private List<Task> tasks;

    public Project(int project_id, String project_name, String project_desc, List<Task> tasks) {
        this.project_id = project_id;
        this.project_name = project_name;
        this.project_desc = project_desc;
        this.tasks = tasks;
    }

    public Project(){

    }
    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_desc() {
        return project_desc;
    }

    public void setProject_desc(String project_desc) {
        this.project_desc = project_desc;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
