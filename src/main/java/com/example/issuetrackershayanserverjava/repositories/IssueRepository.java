package com.example.issuetrackershayanserverjava.repositories;

import com.example.issuetrackershayanserverjava.models.Issue;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IssueRepository extends CrudRepository<Issue, Long> {
String GET_ISSUES_FOR_USER_QUERY = "SELECT\n" +
            "    users.id as 'userId',\n" +
            "    users.username as 'username',\n" +
            "    projects.id as 'projectId'," +
            "    projects.title as 'projectTitle',\n" +
            "    issues.id as 'issueId',\n" +
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
            "    users.id = :uid ORDER BY issues.id DESC";


    String GET_MATCHING_ISSUES_FOR_USER_QUERY = "SELECT\n" +
            "    users.id as 'userId',\n" +
            "    users.username as 'username',\n" +
            "    projects.id as 'projectId'," +
            "    projects.title as 'projectTitle',\n" +
            "    issues.id as 'issueId',\n" +
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
            "    users.id = :uid AND issues.description LIKE :description_string ORDER BY issues.id DESC";
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

    @Query(value=GET_ISSUES_FOR_USER_QUERY, nativeQuery = true)
    public List<UserIssues> findIssuesForUser(@Param("uid") Long userId);

    @Query(value=GET_MATCHING_ISSUES_FOR_USER_QUERY, nativeQuery = true)
    public List<UserIssues> findMatchingIssuesForUser(@Param("uid") Long userId,
                                                      @Param("description_string") String descriptionString);

}
