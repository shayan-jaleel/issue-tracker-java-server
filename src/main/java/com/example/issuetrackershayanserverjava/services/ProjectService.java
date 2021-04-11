package com.example.issuetrackershayanserverjava.services;

import com.example.issuetrackershayanserverjava.models.Issue;
import com.example.issuetrackershayanserverjava.models.Project;
import com.example.issuetrackershayanserverjava.models.User;
import com.example.issuetrackershayanserverjava.repositories.IssueRepository;
import com.example.issuetrackershayanserverjava.repositories.ProjectRepository;
import com.example.issuetrackershayanserverjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    IssueRepository issueRepository;

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
    public Project findProjectForIssue(Long id){
        Issue issue = issueRepository.findById(id).get();
        return issue.getProject();
    }
    public Set<Project> findProjectsForUser(Long uid){
        User user = userRepository.findById(uid).get();
        return user.getProjects();
    }
    public Integer addProjectToUser(Long uid, Long pid){
        User user = userRepository.findById(uid).get();
        Project project = projectRepository.findById(pid).get();

//        List<Project> curProjectListForUser = new ArrayList<>(user.getProjects());
//        curProjectListForUser.add(project);
//        user.setProjects(curProjectListForUser);

        user.getProjects().add(project);
        User user1 = userRepository.save(user);
        project.getUsers().add(user1);
        Project project1 = projectRepository.save(project);

//        List<User> curUserListForProject = new ArrayList<>(project.getUsers());
//        curUserListForProject.add(user1);
//        project.setUsers(curUserListForProject);
//        Project project1 = projectRepository.save(project);
        return 1;
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
