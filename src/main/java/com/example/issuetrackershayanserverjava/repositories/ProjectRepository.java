package com.example.issuetrackershayanserverjava.repositories;

import com.example.issuetrackershayanserverjava.models.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository
        extends CrudRepository<Project, Long> {
}
