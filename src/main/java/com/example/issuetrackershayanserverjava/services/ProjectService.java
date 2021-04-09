package com.example.issuetrackershayanserverjava.services;

import com.example.issuetrackershayanserverjava.models.Issue;
import com.example.issuetrackershayanserverjava.models.Project;
import com.example.issuetrackershayanserverjava.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    // implement crud operations
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }
    public List<Project> findAllProjects() {
        return (List<Project>)projectRepository.findAll();
    }
    public Project findProjectById(Long id) {
        //TODO: See about isPresent()
        return projectRepository.findById(id).get();
    }
    public Integer updateProject(Long id, Project newProject) {
        Project originalProject = findProjectById(id);
        originalProject.setDescription(newProject.getDescription());
        originalProject.setTitle(newProject.getTitle());
        projectRepository.save(originalProject);
        return 1;
    }
    public Integer deleteProject(Long id) {
        projectRepository.deleteById(id);
        return 1;
    }
//    public List<Issue> findIssuesForProject(Long id){
//        Project project = projectRepository.findById(id).get();
//        return project.getIssues();
//    }
//    public Issue createIssueForProject(Long pid, Issue issue){
//        Project project = projectRepository.findById(pid).get();
//        project.addIssue(issue);
//        projectRepository.save(project);
//        return issue;
//    }
}
