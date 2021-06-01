package com.example.issuetrackershayanserverjava.controllers;

import com.example.issuetrackershayanserverjava.models.Role;
import com.example.issuetrackershayanserverjava.models.User;
import com.example.issuetrackershayanserverjava.services.RoleService;
import com.example.issuetrackershayanserverjava.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = {"http://localhost:3000",
        "https://issue-tracker-client-shayan.herokuapp.com",
        "http://issue-tracker-client-shayan.herokuapp.com"}, allowCredentials = "true")
public class SessionController {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @PostMapping("/api/register")
    public User register(@RequestBody User user,
                         HttpSession session) {
        Role role = user.getRole();
        User createdUser = userService.createUserForRole(role == null ? 2 : role.getId(), user);
        session.setAttribute("currentUser", createdUser);
        return createdUser;
    }

    @GetMapping("/api/profile")
    public User profile(HttpSession session) {
        User currentUser = (User)
                session.getAttribute("currentUser");
        return currentUser;
    }

    @PostMapping("/api/login")
    public User login(@RequestBody User credentials,
                          HttpSession session) {
        String username = credentials.getUsername();
        String password = credentials.getPassword();
        User matchedUser = userService.findUserForUsernamePassword(username, password);
        if(matchedUser != null){
            session.setAttribute("currentUser", matchedUser);
            return matchedUser;
        }
        else return null;
    }



    @PostMapping("/api/logout")
    public void logout
            (HttpSession session) {
        session.invalidate();
    }


}
