package com.example.issuetrackershayanserverjava.controllers;

import com.example.issuetrackershayanserverjava.models.Issue;
import com.example.issuetrackershayanserverjava.models.Project;
import com.example.issuetrackershayanserverjava.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProjectController {
    @Autowired
    ProjectService service;// = new WidgetService();

    @PostMapping("/api/projects")
    public Project createProject(
            @RequestBody Project project) {
        return service.createProject(project);
    }

    @GetMapping("/api/projects")
    public List<Project> findAllProjects() {
        return service.findAllProjects();
    }

    @GetMapping("/api/projects/{pid}")
    public Project findProjectById(
            @PathVariable("pid") Long id) {
        return service.findProjectById(id);
    }

    @DeleteMapping("/api/projects/{pid}")
    public Integer deleteProject(@PathVariable("pid") Long id) {
        return service.deleteProject(id);
    }

    @PutMapping("/api/projects/{pid}")
    public Integer updateProject(
            @PathVariable("pid") Long id,
            @RequestBody Project project) {
        return service.updateProject(id, project);
    }

}
