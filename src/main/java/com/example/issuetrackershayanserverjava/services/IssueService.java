package com.example.issuetrackershayanserverjava.services;

import com.example.issuetrackershayanserverjava.models.Issue;
import com.example.issuetrackershayanserverjava.models.Project;
import com.example.issuetrackershayanserverjava.repositories.IssueRepository;
import com.example.issuetrackershayanserverjava.repositories.ProjectRepository;
import com.example.issuetrackershayanserverjava.repositories.UserIssues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

@Service
public class IssueService {
    @Autowired
    IssueRepository issueRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    EntityManagerFactory entityManagerFactory;

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
    public Issue updateIssue(Long id, Issue newIssue) {
        Issue originalIssue = findIssueById(id);
        originalIssue.setDescription(newIssue.getDescription());
        originalIssue.setPriority(newIssue.getPriority());
        originalIssue.setStatus(newIssue.getStatus());
        originalIssue.setType(newIssue.getType());
        //TODO:set comments?
//        originalIssue.setProject(newIssue.getProject());
        return issueRepository.save(originalIssue);
//        return 1;
    }
    public Page<UserIssues> findIssuesForUser(Long userId,
                                              int pageNum, int pageSize){
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<UserIssues> returnedPage = issueRepository.findIssuesForUser(userId, pageable);
        return returnedPage;
    }
    public List<UserIssues> findMatchingIssuesForUser(Long userId, String descriptionString){
        String lookupString = "%"+descriptionString+"%";
        List<UserIssues> returnedList = issueRepository.findMatchingIssuesForUser(userId, lookupString);
        return returnedList;
    }
    public Page<UserIssues> findMatchingIssuesForUser(Long userId, String descriptionString,
                                                      int pageNum, int pageSize){
        String lookupString = "%"+descriptionString+"%";
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<UserIssues> returnedPage = issueRepository.findMatchingIssuesForUser(userId, lookupString, pageable);
        return returnedPage;
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