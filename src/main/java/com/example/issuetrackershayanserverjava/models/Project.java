package com.example.issuetrackershayanserverjava.models;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Represents a project, which consists of a title and a description.
 * A project has Users assigned to it, who work on Issues for that project.
 */
@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Column(length = 10000)
    private String description;

    @OneToMany(mappedBy = "project")
    private List<Issue> issues;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "project_users",
            joinColumns = {@JoinColumn(name = "project_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})

    private Set<User> users;


    public Project(Long id, String title, String description, Set<User> users) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.users = users;
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

    public Issue addIssue(Issue issue) {
        this.issues.add(issue);
        return issue;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
