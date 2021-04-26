package com.example.issuetrackershayanserverjava.services;

import com.example.issuetrackershayanserverjava.models.Project;
import com.example.issuetrackershayanserverjava.models.Role;
import com.example.issuetrackershayanserverjava.models.User;
import com.example.issuetrackershayanserverjava.repositories.ProjectRepository;
import com.example.issuetrackershayanserverjava.repositories.RoleRepository;
import com.example.issuetrackershayanserverjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    ProjectRepository projectRepository;

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
    public User findUserForUsernamePassword(String username, String password){
        List<User> matchedUsers = userRepository.findUserForUsernamePassword(username, password);
        if(matchedUsers == null || matchedUsers.size() == 0) return null;
        return matchedUsers.get(0);
    }

    public List<User> findAllUsers() {
        return (List<User>)userRepository.findAll();
    }

    public User findUserById(Long id) {
        //TODO: See about isPresent()
        return userRepository.findById(id).get();
    }
    public User updateUser(Long id, User newUser) {
        User originalUser = findUserById(id);
        originalUser.setEmail(newUser.getEmail());
        originalUser.setUsername(newUser.getUsername());
        originalUser.setFirstname(newUser.getFirstname());
        originalUser.setLastname(newUser.getLastname());
        originalUser.setPassword(newUser.getPassword());
        //TODO: role change here?
//        originalUser.setRole();
        return userRepository.save(originalUser);
//        return 1;
    }

    public User updateUser(Long uid, Long rid, User newUser) {
        User originalUser = findUserById(uid);
        originalUser.setEmail(newUser.getEmail());
        originalUser.setUsername(newUser.getUsername());
        originalUser.setFirstname(newUser.getFirstname());
        originalUser.setLastname(newUser.getLastname());
        originalUser.setPassword(newUser.getPassword());
        Role role = roleRepository.findById(rid).get();
        originalUser.setRole(role);
        return userRepository.save(originalUser);
//        return 1;
    }


    public Set<User> findUsersForProject(Long pid){
        Project project = projectRepository.findById(pid).get();
        return project.getUsers();
    }
    public Integer addUserToProject(Long pid, Long uid){
        User user = userRepository.findById(uid).get();
        Project project = projectRepository.findById(pid).get();

        project.getUsers().add(user);
        Project project1 = projectRepository.save(project);
        user.getProjects().add(project1);
        User user1 = userRepository.save(user);

//        List<User> curUserListForProject = new ArrayList<>(project.getUsers());
//        curUserListForProject.add(user1);
//        project.setUsers(curUserListForProject);
//        Project project1 = projectRepository.save(project);
        return 1;
    }
    public Integer removeUserFromProject(Long pid, Long uid){
        User user = userRepository.findById(uid).get();
        Project project = projectRepository.findById(pid).get();

        project.getUsers().remove(user);
        Project project1 = projectRepository.save(project);
        user.getProjects().remove(project1);
        User user1 = userRepository.save(user);

//        List<User> curUserListForProject = new ArrayList<>(project.getUsers());
//        curUserListForProject.add(user1);
//        project.setUsers(curUserListForProject);
//        Project project1 = projectRepository.save(project);
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
