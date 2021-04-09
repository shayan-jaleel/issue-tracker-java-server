package com.example.issuetrackershayanserverjava.controllers;

import com.example.issuetrackershayanserverjava.models.Issue;
import com.example.issuetrackershayanserverjava.models.Project;
import com.example.issuetrackershayanserverjava.services.IssueService;
import com.example.issuetrackershayanserverjava.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class IssueController {
    @Autowired
    IssueService service;// = new WidgetService();

    @PostMapping("/api/projects/{pid}/issues")
    public Issue createIssueForProject(
            @PathVariable("pid") Long pid,
            @RequestBody Issue issue) {
        return service.createIssueForProject(pid, issue);
    }

    @GetMapping("/api/projects/{pId}/issues")
    public List<Issue> findIssuesForProject(
            @PathVariable("pId") Long id){
        return service.findIssuesForProject(id);
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
    public Integer updateIssue(
            @PathVariable("iid") Long id,
            @RequestBody Issue issue) {
        return service.updateIssue(id, issue);
    }
}