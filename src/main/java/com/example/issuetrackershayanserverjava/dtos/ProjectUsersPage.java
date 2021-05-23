package com.example.issuetrackershayanserverjava.dtos;

import com.example.issuetrackershayanserverjava.repositories.ProjectIssues;
import com.example.issuetrackershayanserverjava.repositories.ProjectUsers;

import java.util.List;

public class ProjectUsersPage implements ItemsPage<ProjectUsers>{
    private List<ProjectUsers> users;
    private Integer currentPage;
    private Integer totalPages;
    private Long totalUsers;
    private Integer pageSize;

    public ProjectUsersPage(List<ProjectUsers> users, Integer currentPage,
                            Integer totalPages, Long totalUsers, Integer pageSize) {
        this.users = users;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.totalUsers = totalUsers;
        this.pageSize = pageSize;
    }

    public ProjectUsersPage() {
    }

    @Override
    public List<ProjectUsers> getItems() {
        return users;
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
        return totalUsers;
    }

    @Override
    public Integer getPageSize() {
        return pageSize;
    }
}
