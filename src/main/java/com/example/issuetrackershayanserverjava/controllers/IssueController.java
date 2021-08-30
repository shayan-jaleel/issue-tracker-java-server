package com.example.issuetrackershayanserverjava.controllers;

import com.example.issuetrackershayanserverjava.dtos.ProjectIssuesPage;
import com.example.issuetrackershayanserverjava.dtos.UserIssuesPage;
import com.example.issuetrackershayanserverjava.dtos.ItemsPage;
import com.example.issuetrackershayanserverjava.models.Issue;
import com.example.issuetrackershayanserverjava.repositories.ProjectIssues;
import com.example.issuetrackershayanserverjava.services.IssueService;
import com.example.issuetrackershayanserverjava.repositories.UserIssues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class IssueController {
    @Autowired
    IssueService service;

    @PostMapping("/api/projects/{pid}/issues")
    public Issue createIssueForProject(
            @PathVariable("pid") Long pid,
            @RequestBody Issue issue) {
        return service.createIssueForProject(pid, issue);
    }

    @GetMapping("/api/projects/{pId}/issues")
    public ItemsPage findIssuesForProject(
            @PathVariable("pId") Long id,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "5") Integer pageSize) {
        Page<ProjectIssues> issuesPage = service.findIssuesForProject(id, pageNum - 1, pageSize);
        ItemsPage returnedProjectIssuesPage = new ProjectIssuesPage(issuesPage.getContent(), pageNum,
                issuesPage.getTotalPages(), issuesPage.getTotalElements(), pageSize);
        return returnedProjectIssuesPage;

    }

    @GetMapping("/api/users/{uId}/issues")
    public ItemsPage findIssuesForUser(
            @PathVariable("uId") Long id,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam("description") Optional<String> descriptionString,
            @RequestParam("open") Boolean isOpen) {
        List<UserIssues> returnedList = new ArrayList<>();
        Page issuesPage;
        if (descriptionString.isPresent()) {
            issuesPage = service.findMatchingIssuesForUser(id, descriptionString.get(), pageNum - 1, pageSize, isOpen);
            returnedList = issuesPage.getContent();
        } else {
            issuesPage = service.findIssuesForUser(id, pageNum - 1, pageSize, isOpen);
            returnedList = issuesPage.getContent();
        }
        ItemsPage returnedUserIssuesPage = new UserIssuesPage(returnedList, pageNum,
                issuesPage.getTotalPages(), issuesPage.getTotalElements(), pageSize);
        return returnedUserIssuesPage;
    }

    @GetMapping("/api/issues")
    public List<Issue> findAllIssues() {
        return service.findAllIssues();
    }

    @GetMapping("/api/issues/{iid}")
    public Issue findIssueById(
            @PathVariable("iid") Long id) {
        return service.findIssueById(id);
    }

    @DeleteMapping("/api/issues/{iid}")
    public Integer deleteIssue(@PathVariable("iid") Long id) {
        return service.deleteIssue(id);
    }

    @PutMapping("/api/issues/{iid}")
    public Issue updateIssue(
            @PathVariable("iid") Long id,
            @RequestBody Issue issue) {
        return service.updateIssue(id, issue);
    }
}