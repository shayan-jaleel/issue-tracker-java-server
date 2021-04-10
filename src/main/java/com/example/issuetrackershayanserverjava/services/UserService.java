package com.example.issuetrackershayanserverjava.services;

import com.example.issuetrackershayanserverjava.models.Role;
import com.example.issuetrackershayanserverjava.models.User;
import com.example.issuetrackershayanserverjava.repositories.RoleRepository;
import com.example.issuetrackershayanserverjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    // implement CRUD operations
    public User createUserForRole(Long rid, User user) {
        Role role = roleRepository.findById(rid).get();
        user.setRole(role);
        return userRepository.save(user);
    }

    public List<User> findUsersForRole(Long rid){
        Role role = roleRepository.findById(rid).get();
        return role.getUsers();
    }

    public List<User> findAllUsers() {
        return (List<User>)userRepository.findAll();
    }

    public User findUserById(Long id) {
        //TODO: See about isPresent()
        return userRepository.findById(id).get();
    }
    public Integer updateUser(Long id, User newUser) {
        User originalUser = findUserById(id);
        originalUser.setEmail(newUser.getEmail());
        originalUser.setFirstname(newUser.getFirstname());
        originalUser.setLastname(newUser.getLastname());
        //TODO: role change here?
//        originalUser.setRole();
        userRepository.save(originalUser);
        return 1;
    }
    public Role findRoleForUser(Long id){
        User user = userRepository.findById(id).get();
        return user.getRole();
    }
    public Integer deleteUser(Long id) {
        userRepository.deleteById(id);
        return 1;
    }
}
