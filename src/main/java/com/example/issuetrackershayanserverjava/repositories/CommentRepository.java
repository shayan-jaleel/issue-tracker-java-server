package com.example.issuetrackershayanserverjava.repositories;

import com.example.issuetrackershayanserverjava.models.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
