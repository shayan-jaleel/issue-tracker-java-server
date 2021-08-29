package com.example.issuetrackershayanserverjava.repositories;

import com.example.issuetrackershayanserverjava.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    String GET_USERS_FOR_PROJECT_QUERY = "select \n" +
            " projects.id as 'projectId',\n" +
            " users.id as 'userId',\n" +
            " users.email as 'email',\n" +
            " users.firstname as 'firstname',\n" +
            " users.lastname as 'lastname',\n" +
            " users.username as 'username'\n" +
            "from projects join project_users \n" +
            "on projects.id = project_users.project_id join users\n" +
            "on users.id = project_users.user_id\n" +
            "where projects.id = :pid";

    String GET_USERS_FOR_PROJECTS_COUNT_QUERY = "select \n" +
            " count(*)\n" +
            "from projects join project_users \n" +
            "on projects.id = project_users.project_id join users\n" +
            "on users.id = project_users.user_id\n" +
            "where projects.id = :pid";

    @Query(value = "SELECT * FROM users WHERE username=:uname AND password=:pass", nativeQuery = true)
    public List<User> findUserForUsernamePassword(@Param("uname") String username, @Param("pass") String password);

    @Query(value = GET_USERS_FOR_PROJECT_QUERY,
            countQuery = GET_USERS_FOR_PROJECTS_COUNT_QUERY,
            nativeQuery = true)
    public Page<ProjectUsers> findUsersForProject(@Param("pid") Long projectId, Pageable pageable);
}
