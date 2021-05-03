package com.example.issuetrackershayanserverjava.dtos;

import com.example.issuetrackershayanserverjava.models.Comment;

import java.util.List;

public interface CommentsPage {
    List<Comment> getComments();
    Integer getCurrentPage();
    Integer getTotalPages();
    Long getTotalComments();
    Integer getPageSize();
}
