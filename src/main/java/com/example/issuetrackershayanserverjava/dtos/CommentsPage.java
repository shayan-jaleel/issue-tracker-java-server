package com.example.issuetrackershayanserverjava.dtos;

import com.example.issuetrackershayanserverjava.models.Comment;

import java.util.List;

public class CommentsPage implements ItemsPage<Comment> {
    private List<Comment> comments;
    private Integer currentPage;
    private Integer totalPages;
    private Long totalComments;
    private Integer pageSize;

    public CommentsPage(List<Comment> comments, Integer currentPage,
                        Integer totalPages, Long totalComments, Integer pageSize) {
        this.comments = comments;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.totalComments = totalComments;
        this.pageSize = pageSize;
    }

    public CommentsPage() {
    }

    @Override
    public List<Comment> getItems() {
        return comments;
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
        return totalComments;
    }

    @Override
    public Integer getPageSize() {
        return pageSize;
    }
}
