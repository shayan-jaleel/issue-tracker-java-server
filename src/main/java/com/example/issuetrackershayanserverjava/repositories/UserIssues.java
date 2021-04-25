package com.example.issuetrackershayanserverjava.repositories;

// using projection: https://stackoverflow.com/a/46089708
public interface UserIssues {
    Long getUserId();
    Long getProjectId();
    String getProjectTitle();
    Long getIssueId();
    String getUsername();
    String getDescription();
    String getPriority();
    String getStatus();
}