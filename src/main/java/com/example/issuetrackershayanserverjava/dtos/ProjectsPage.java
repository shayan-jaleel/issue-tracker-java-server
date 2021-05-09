package com.example.issuetrackershayanserverjava.dtos;

import java.util.List;

public class ProjectsPage implements ItemsPage<ProjectMain> {
    private List<ProjectMain> projects;
    private Integer currentPage;
    private Integer totalPages;
    private Long totalProjects;
    private Integer pageSize;

    public ProjectsPage(List<ProjectMain> projects, Integer currentPage,
                        Integer totalPages, Long totalProjects, Integer pageSize) {
        this.projects = projects;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.totalProjects = totalProjects;
        this.pageSize = pageSize;
    }

    public ProjectsPage() {
    }

    @Override
    public List<ProjectMain> getItems() {
        return projects;
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
        return totalProjects;
    }

    @Override
    public Integer getPageSize() {
        return pageSize;
    }
}

