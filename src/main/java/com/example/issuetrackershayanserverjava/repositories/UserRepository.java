package com.example.issuetrackershayanserverjava.repositories;

import com.example.issuetrackershayanserverjava.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
