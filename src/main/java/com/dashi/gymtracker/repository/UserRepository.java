package com.dashi.gymtracker.repository;

import com.dashi.gymtracker.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername (String username);
}