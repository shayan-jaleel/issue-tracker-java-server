package com.example.issuetrackershayanserverjava.repositories;

import com.example.issuetrackershayanserverjava.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query(value="SELECT * FROM users WHERE username=:uname AND password=:pass", nativeQuery = true)
    public List<User> findUserForUsernamePassword(@Param("uname") String username, @Param("pass") String password);
}
