package com.example.issuetrackershayanserverjava.models;

import javax.persistence.*;

/**
 * Represents a comment. Includes the time when the comment was made as well as whether or not it was edited.
 * A Comment is made by a User on an Issue.
 */
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private Long creationTime;
    private Boolean edited;

    @ManyToOne
    private Issue issue;

    @ManyToOne
    private User user;

    public Comment(Long id, String text, Issue issue, User user,
                   Long creationTime, Boolean edited) {
        this.id = id;
        this.text = text;
        this.issue = issue;
        this.user = user;
        this.creationTime = creationTime;
        this.edited = edited;
    }

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Long creationUnixTime) {
        this.creationTime = creationUnixTime;
    }

    public Boolean getEdited() {
        return edited;
    }

    public void setEdited(Boolean edited) {
        this.edited = edited;
    }
}
