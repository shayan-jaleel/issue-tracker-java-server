package com.example.issuetrackershayanserverjava.models;

public class UserIssues {
    private long userId;
    private long projectId;
    private long issueId;
    private String username;
    private String description;
    private String priority;
    private String status;

    public UserIssues(long userId, long projectId, long issueId,
                      String username, String description, String priority,
                      String status) {
        this.userId = userId;
        this.projectId = projectId;
        this.issueId = issueId;
        this.username = username;
        this.description = description;
        this.priority = priority;
        this.status = status;
    }

    public UserIssues() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getIssueId() {
        return issueId;
    }

    public void setIssueId(long issueId) {
        this.issueId = issueId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
