package com.example.issuetrackershayanserverjava.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Represents an Issue/Ticket for a Project. In addition to a description of the issue, it includes the priority level
 * (LOW, MEDIUM, HIGH), as well as the issue status (OPEN, CLOSED). An issue can have many comments.
 */
@Entity
@Table(name = "issues")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //TODO: change types
    private String priority;
    private String status;
    private String type;
    private String description;

    @ManyToOne
    @JsonIgnore
    private Project project;

    @OneToMany(mappedBy = "issue")
    @JsonIgnore
    private List<Comment> comments;

    public Issue(Long id, String priority,
                 String status, String type,
                 String description, Project project,
                 List<Comment> comments) {
        this.id = id;
        this.priority = priority;
        this.status = status;
        this.type = type;
        this.description = description;
        this.project = project;
    }

    public Issue() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
