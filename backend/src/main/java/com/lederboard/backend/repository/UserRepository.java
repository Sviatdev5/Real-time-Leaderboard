package com.lederboard.backend.repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lederboard.backend.Entity.User;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findUserByUserName(String userName);
    Optional<User> findByEmail(String email);
    List<User> findTop10ByOrderByTotalScoreDesc();
    boolean existsByUserName(String userName);
    boolean existsByEmail(String email);
}
