package com.example.issuetrackershayanserverjava.models;

public class Issue {
    private Long id;
    //TODO: change types
    private String priority;
    private String status;
    private String type;
    private String description;

    public Issue(Long id, String priority, String status, String type, String description) {
        this.id = id;
        this.priority = priority;
        this.status = status;
        this.type = type;
        this.description = description;
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
}
