package com.example.issuetrackershayanserverjava.controllers;

import com.example.issuetrackershayanserverjava.dtos.ItemsPage;
import com.example.issuetrackershayanserverjava.dtos.ProjectUsersPage;
import com.example.issuetrackershayanserverjava.models.User;
import com.example.issuetrackershayanserverjava.repositories.ProjectUsers;
import com.example.issuetrackershayanserverjava.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = {"http://localhost:3000",
        "https://issue-tracker-client-shayan.herokuapp.com",
        "http://issue-tracker-client-shayan.herokuapp.com"}, allowCredentials = "true")
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
            @PathVariable("rid") Long id) {
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

    @GetMapping("/api/projects/{pId}/users-p")
    public ItemsPage findPaginatedUsersForProject(
            @PathVariable("pId") Long id,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "5") Integer pageSize) {
        Page<ProjectUsers> usersPage = service.findUsersForProject(id, pageNum - 1, pageSize);
        ItemsPage returnedProjectUsersPage = new ProjectUsersPage(usersPage.getContent(), pageNum,
                usersPage.getTotalPages(), usersPage.getTotalElements(), pageSize);
        return returnedProjectUsersPage;
    }

    @GetMapping("/api/projects/{pid}/users/{uid}")
    public Integer addUserToProject(
            @PathVariable("pid") Long pid,
            @PathVariable("uid") Long uid) {
        return service.addUserToProject(pid, uid);
    }

    @DeleteMapping("/api/projects/{pid}/users/{uid}")
    public Integer removeUserFromProject(
            @PathVariable("pid") Long pid,
            @PathVariable("uid") Long uid) {
        return service.removeUserFromProject(pid, uid);
    }

    @DeleteMapping("/api/users/{uid}")
    public Integer deleteUser(@PathVariable("uid") Long id) {
        return service.deleteUser(id);
    }

    @PutMapping("/api/users/{uid}")
    public User updateUser(
            @PathVariable("uid") Long id,
            @RequestBody User user) {
        return service.updateUser(id, user);
    }

    @PutMapping("/api/roles/{rid}/users/{uid}")
    public User updateUser(
            @PathVariable("uid") Long uid,
            @PathVariable("rid") Long rid,
            @RequestBody User user) {
        return service.updateUser(uid, rid, user);
    }
}