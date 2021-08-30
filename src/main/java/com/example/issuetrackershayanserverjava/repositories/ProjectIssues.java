package com.example.issuetrackershayanserverjava.repositories;

// using projection: https://stackoverflow.com/a/46089708
public interface ProjectIssues {

    Long getProjectId();

    Long getIssueId();

    String getDescription();

    String getPriority();

    String getStatus();

    String getType();
}
