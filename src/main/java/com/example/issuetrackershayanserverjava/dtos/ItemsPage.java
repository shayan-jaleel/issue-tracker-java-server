package com.example.issuetrackershayanserverjava.dtos;

import com.example.issuetrackershayanserverjava.models.Comment;

import java.util.List;

public interface ItemsPage<T> {
    List<T> getItems();
    Integer getCurrentPage();
    Integer getTotalPages();
    Long getTotalItems();
    Integer getPageSize();
}
