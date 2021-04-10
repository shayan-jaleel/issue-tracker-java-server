package com.example.issuetrackershayanserverjava.services;

import com.example.issuetrackershayanserverjava.models.Issue;
import com.example.issuetrackershayanserverjava.models.Project;
import com.example.issuetrackershayanserverjava.repositories.IssueRepository;
import com.example.issuetrackershayanserverjava.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueService {
    @Autowired
    IssueRepository issueRepository;
    @Autowired
    ProjectRepository projectRepository;

    // implement CRUD operations
    public Issue createIssueForProject(Long pid, Issue issue) {
        Project project = projectRepository.findById(pid).get();
        issue.setProject(project);
        return issueRepository.save(issue);
    }
    //Should this be implemented here?
    public List<Issue> findIssuesForProject(Long pid){
        Project project = projectRepository.findById(pid).get();
        return project.getIssues();
    }
    public List<Issue> findAllIssues() {
        return (List<Issue>)issueRepository.findAll();
    }
    public Issue findIssueById(Long id) {
        //TODO: See about isPresent()
        return issueRepository.findById(id).get();
    }
    public Integer updateIssue(Long id, Issue newIssue) {
        Issue originalIssue = findIssueById(id);
        originalIssue.setDescription(newIssue.getDescription());
        originalIssue.setPriority(newIssue.getPriority());
        originalIssue.setStatus(newIssue.getStatus());
        originalIssue.setType(newIssue.getType());
        //TODO:set comments?
//        originalIssue.setProject(newIssue.getProject());
        issueRepository.save(originalIssue);
        return 1;
    }
    public Project findProjectForIssue(Long id){
        Issue issue = issueRepository.findById(id).get();
        return issue.getProject();
    }
    public Integer deleteIssue(Long id) {
        issueRepository.deleteById(id);
        return 1;
    }
}