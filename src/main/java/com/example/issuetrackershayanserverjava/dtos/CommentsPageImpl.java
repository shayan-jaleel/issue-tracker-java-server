package com.example.issuetrackershayanserverjava.dtos;

import com.example.issuetrackershayanserverjava.models.Comment;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class CommentsPageImpl implements CommentsPage{
    private List<Comment> comments;
    private Integer currentPage;
    private Integer totalPages;
    private Long totalComments;
    private Integer pageSize;

    public CommentsPageImpl(List<Comment> comments, Integer currentPage,
                            Integer totalPages, Long totalComments, Integer pageSize) {
        this.comments = comments;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.totalComments = totalComments;
        this.pageSize = pageSize;
    }

    public CommentsPageImpl() {
    }

    @Override
    public List<Comment> getComments() {
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
    public Long getTotalComments() {
        return totalComments;
    }

    @Override
    public Integer getPageSize() {
        return pageSize;
    }
}
