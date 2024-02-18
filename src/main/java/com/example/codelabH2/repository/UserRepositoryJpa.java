package com.example.codelabH2.repository;

import com.example.codelabH2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryJpa extends JpaRepository<User, Long> {
}
