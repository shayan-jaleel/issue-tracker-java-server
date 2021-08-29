package com.example.issuetrackershayanserverjava.dtos;

import java.util.List;

public interface ItemsPage<T> {

    List<T> getItems();

    Integer getCurrentPage();

    Integer getTotalPages();

    Long getTotalItems();

    Integer getPageSize();
}
