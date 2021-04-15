package com.example.issuetrackershayanserverjava.controllers;

import com.example.issuetrackershayanserverjava.models.Comment;
import com.example.issuetrackershayanserverjava.models.Project;
import com.example.issuetrackershayanserverjava.models.User;
import com.example.issuetrackershayanserverjava.services.CommentService;
import com.example.issuetrackershayanserverjava.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    UserService service;

    //TODO: Should I change endpoint?
    @PostMapping("/api/roles/{rid}/users")
    public User createUserForRole(
            @PathVariable("rid") Long rid,
            @RequestBody User user) {
        return service.createUserForRole(rid, user);
    }

    @GetMapping("/api/roles/{rid}/users")
    public List<User> findUsersForRole(
            @PathVariable("rid") Long id){
        return service.findUsersForRole(id);
    }

    @GetMapping("/api/users")
    public List<User> findAllUsers() {
        return service.findAllUsers();
    }

    @GetMapping("/api/users/{uid}")
    public User findUserById(
            @PathVariable("uid") Long id) {
        return service.findUserById(id);
    }

    @GetMapping("/api/projects/{pid}/users")
    public Set<User> findUsersForProject(
            @PathVariable("pid") Long id) {
        return service.findUsersForProject(id);
    }
    @GetMapping("/api/projects/{pid}/users/{uid}")
    public Integer addUserToProject(
            @PathVariable("pid") Long uid,
            @PathVariable("uid") Long pid) {
        return service.addUserToProject(pid, uid);
    }

    @DeleteMapping("/api/users/{uid}")
    public Integer deleteUser(@PathVariable("uid") Long id) {
        return service.deleteUser(id);
    }

    @PutMapping("/api/users/{uid}")
    public Integer updateUser(
            @PathVariable("uid") Long id,
            @RequestBody User user) {
        return service.updateUser(id, user);
    }
}