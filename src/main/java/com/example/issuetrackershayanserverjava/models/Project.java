package com.example.issuetrackershayanserverjava.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @OneToMany(mappedBy = "project")
    private List<Issue> issues;


    public Project(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Project() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    public Issue addIssue(Issue issue){
        this.issues.add(issue);
//        if(issue.getProject() != this){
//            issue.setProject(this);
//        }
        return issue;
    }
}
