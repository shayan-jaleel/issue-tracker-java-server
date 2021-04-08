package com.example.issuetrackershayanserverjava.services;

import com.example.issuetrackershayanserverjava.models.Issue;
import com.example.issuetrackershayanserverjava.repositories.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueService {
    @Autowired
    IssueRepository issueRepository;

    // implement crud operations
    public Issue createIssue(Issue issue) {
        return issueRepository.save(issue);
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
        issueRepository.save(originalIssue);
        return 1;
    }
    public Integer deleteIssue(Long id) {
        issueRepository.deleteById(id);
        return 1;
    }
}