package com.example.issuetrackershayanserverjava.dtos;

import com.example.issuetrackershayanserverjava.repositories.ProjectIssues;

import java.util.List;

public class ProjectIssuesPage implements ItemsPage<ProjectIssues> {
    private List<ProjectIssues> issues;
    private Integer currentPage;
    private Integer totalPages;
    private Long totalIssues;
    private Integer pageSize;

    public ProjectIssuesPage(List<ProjectIssues> issues, Integer currentPage,
                             Integer totalPages, Long totalIssues, Integer pageSize) {
        this.issues = issues;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.totalIssues = totalIssues;
        this.pageSize = pageSize;
    }

    public ProjectIssuesPage() {
    }

    @Override
    public List<ProjectIssues> getItems() {
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
