package com.rev.TaskManagement.dao;

import com.rev.TaskManagement.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends JpaRepository<Project,Integer> {
}
