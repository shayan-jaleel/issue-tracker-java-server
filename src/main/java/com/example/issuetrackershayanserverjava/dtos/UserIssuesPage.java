package com.example.issuetrackershayanserverjava.dtos;

import com.example.issuetrackershayanserverjava.repositories.UserIssues;

import java.util.List;

public class UserIssuesPage implements ItemsPage<UserIssues> {
    private List<UserIssues> issues;
    private Integer currentPage;
    private Integer totalPages;
    private Long totalIssues;
    private Integer pageSize;

    public UserIssuesPage(List<UserIssues> issues, Integer currentPage, Integer totalPages, Long totalIssues, Integer pageSize) {
        this.issues = issues;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.totalIssues = totalIssues;
        this.pageSize = pageSize;
    }

    public UserIssuesPage() {
    }

    @Override
    public List<UserIssues> getItems() {
        return issues;
    }

    @Override
    public Integer getCurrentPage() {
        return currentPage;
    }

    @Override
    public Integer getTotalPages() {
        return totalPages;
    }

    @Override
    public Long getTotalItems() {
        return totalIssues;
    }

    @Override
    public Integer getPageSize() {
        return pageSize;
    }
}
