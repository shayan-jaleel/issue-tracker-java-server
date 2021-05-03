package com.example.issuetrackershayanserverjava.repositories;

import com.example.issuetrackershayanserverjava.models.Comment;
import com.example.issuetrackershayanserverjava.models.Issue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Page<Comment> findByIssue(Issue issue, Pageable pageable);
}
