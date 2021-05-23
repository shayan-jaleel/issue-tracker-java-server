package com.example.issuetrackershayanserverjava.repositories;

public interface ProjectIssues {
    Long getProjectId();
    Long getIssueId();
    String getDescription();
    String getPriority();
    String getStatus();
    String getType();
}
