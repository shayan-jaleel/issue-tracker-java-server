package com.example.issuetrackershayanserverjava.controllers;

import com.example.issuetrackershayanserverjava.models.Role;
import com.example.issuetrackershayanserverjava.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class RoleController {
    @Autowired
    RoleService service;

    @PostMapping("/api/roles")
    public Role createRole(
            @RequestBody Role role) {
        return service.createRole(role);
    }

    @GetMapping("/api/roles")
    public List<Role> findAllRoles() {
        return service.findAllRoles();
    }

    @GetMapping("/api/roles/{rid}")
    public Role findRoleById(
            @PathVariable("rid") Long id) {
        return service.findRoleById(id);
    }

    @DeleteMapping("/api/roles/{rid}")
    public Integer deleteRole(@PathVariable("rid") Long id) {
        return service.deleteRole(id);
    }

    @PutMapping("/api/roles/{rid}")
    public Integer updateRole(
            @PathVariable("rid") Long id,
            @RequestBody Role role) {
        return service.updateRole(id, role);
    }

}