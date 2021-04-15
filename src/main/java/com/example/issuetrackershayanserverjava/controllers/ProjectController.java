package com.example.issuetrackershayanserverjava.controllers;

import com.example.issuetrackershayanserverjava.models.Issue;
import com.example.issuetrackershayanserverjava.models.Project;
import com.example.issuetrackershayanserverjava.models.ProjectMain;
import com.example.issuetrackershayanserverjava.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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
    public List<ProjectMain> findAllProjects() {
        return service.findAllProjects();
    }

    @GetMapping("/api/projects/{pid}")
    public Project findProjectById(
            @PathVariable("pid") Long id) {
        return service.findProjectById(id);
    }
    @GetMapping("/api/users/{uid}/projects")
    public Set<Project> findProjectsForUser(
            @PathVariable("uid") Long id) {
        return service.findProjectsForUser(id);
    }
    @GetMapping("/api/issues/{iid}/projects")
    public Project findProjectForIssue(
            @PathVariable("iid") Long id) {
        return service.findProjectForIssue(id);
    }
    @GetMapping("/api/users/{uid}/projects/{pid}")
    public Integer addProjectToUser(
            @PathVariable("uid") Long uid,
            @PathVariable("pid") Long pid) {
        return service.addProjectToUser(uid, pid);
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
