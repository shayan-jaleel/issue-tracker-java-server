package com.example.issuetrackershayanserverjava.controllers;

import com.example.issuetrackershayanserverjava.dtos.ItemsPage;
import com.example.issuetrackershayanserverjava.dtos.ProjectsPage;
import com.example.issuetrackershayanserverjava.models.Project;
import com.example.issuetrackershayanserverjava.dtos.ProjectMain;
import com.example.issuetrackershayanserverjava.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

//    @GetMapping("/api/projects")
//    public List<ProjectMain> findAllProjects() {
//        return service.findAllProjects();
//    }


    @GetMapping("/api/projects")
    public ItemsPage findAllProjects(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortField,
            @RequestParam(defaultValue = "desc") String sortDir) {
        Page<Project> projectPage = service.findAllPaginatedSortedProjects(pageNum-1,
                pageSize, sortField, sortDir);
        List<Project> projectList = projectPage.getContent();
        //Convert project to projectMain
        List<ProjectMain> projectMainList = new ArrayList<>();
        for(Project project: projectList){
            projectMainList.add(new ProjectMain(project.getId(), project.getTitle(), project.getDescription()));
        }
        ItemsPage projectsPage = new ProjectsPage(projectMainList, pageNum,
                projectPage.getTotalPages(), projectPage.getTotalElements(), pageSize);
        return projectsPage;
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
