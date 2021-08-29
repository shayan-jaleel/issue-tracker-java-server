package com.example.issuetrackershayanserverjava.services;

import com.example.issuetrackershayanserverjava.models.Role;
import com.example.issuetrackershayanserverjava.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> findAllRoles() {
        return (List<Role>) roleRepository.findAll();
    }

    public Role findRoleById(Long id) {
        //TODO: See about isPresent()
        return roleRepository.findById(id).get();
    }

    public Integer updateRole(Long id, Role newRole) {
        Role originalRole = findRoleById(id);
        originalRole.setName(newRole.getName());
        //TODO: set users?
        roleRepository.save(originalRole);
        return 1;
    }

    public Integer deleteRole(Long id) {
        roleRepository.deleteById(id);
        return 1;
    }
}