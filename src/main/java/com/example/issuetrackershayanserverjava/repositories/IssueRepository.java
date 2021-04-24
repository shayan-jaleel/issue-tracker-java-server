package com.example.issuetrackershayanserverjava.repositories;

import com.example.issuetrackershayanserverjava.models.Issue;
import com.example.issuetrackershayanserverjava.models.UserIssues;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IssueRepository extends CrudRepository<Issue, Long> {

//    SELECT
//    users.id as 'user_id',
//    users.username as 'username',
//    projects.id as 'project_id',
//    issues.id as 'issue_id',
//    issues.description as 'description',
//    issues.priority as 'priority',
//    issues.status as 'status'
//    FROM users
//    left join project_users
//    on users.id = project_users.user_id
//    left join projects
//    on project_users.project_id = projects.id
//    left join issues
//    on projects.id = issues.project_id
//    where
//    users.id = 3;

    @Query(value="SELECT\n" +
            "    users.id as 'user_id',\n" +
            "    users.username as 'username',\n" +
            "    projects.id as 'project_id',\n" +
            "    issues.id as 'issue_id',\n" +
            "    issues.description as 'description',\n" +
            "    issues.priority as 'priority',\n" +
            "    issues.status as 'status'\n" +
            "    FROM users\n" +
            "    left join project_users\n" +
            "    on users.id = project_users.user_id\n" +
            "    left join projects\n" +
            "    on project_users.project_id = projects.id\n" +
            "    left join issues\n" +
            "    on projects.id = issues.project_id\n" +
            "    where\n" +
            "    users.id = :uid", nativeQuery = true)
    public List<Object> findIssuesForUser(@Param("uid") Long userId);

}
