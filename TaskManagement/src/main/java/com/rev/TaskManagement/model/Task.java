package com.rev.TaskManagement.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Columns;

@Entity
@Table
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long task_id;
    @Column
    private String task_name;
    @Column(name = "user_id")
    private int user;

    private int task;
@Column
    private String description;
    @Column(name="milestone_id")
    private int milestone;

    @Override
    public String toString() {
        return "Task{" +
                "task_id=" + task_id +
                ", task_name='" + task_name + '\'' +
                ", user=" + user +
                ", description='" + description + '\'' +
                ", milestone=" + milestone +
                '}';
    }

    public Task(long task_id, String task_name, int user, int task, String description, int milestone) {
        this.task_id = task_id;
        this.task_name = task_name;
        this.user = user;
        this.task = task;
        this.description = description;
        this.milestone = milestone;
    }

    public long getTask_id() {
        return task_id;
    }

    public void setTask_id(long task_id) {
        this.task_id = task_id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public int getTask() {
        return task;
    }

    public void setTask(int task) {
        this.task = task;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMilestone() {
        return milestone;
    }

    public void setMilestone(int milestone) {
        this.milestone = milestone;
    }

    public Task(){

    }
}
