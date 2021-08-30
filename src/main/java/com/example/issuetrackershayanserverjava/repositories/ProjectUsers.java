package com.example.issuetrackershayanserverjava.repositories;

// using projection: https://stackoverflow.com/a/46089708
public interface ProjectUsers {

    Long getProjectId();

    Long getUserId();

    String getFirstname();

    String getLastname();

    String getUsername();
}
