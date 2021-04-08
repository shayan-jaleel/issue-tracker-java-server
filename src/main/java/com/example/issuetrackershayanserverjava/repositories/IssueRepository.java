package com.example.issuetrackershayanserverjava.repositories;

import com.example.issuetrackershayanserverjava.models.Issue;
import org.springframework.data.repository.CrudRepository;

public interface IssueRepository extends CrudRepository<Issue, Long> {
}
