package com.lederboard.backend.service;
import org.springframework.stereotype.Service;

import com.lederboard.backend.Entity.User;
import com.lederboard.backend.dto.UserRegistration.RequestDTO;
import com.lederboard.backend.dto.UserRegistration.ResponseDTO;
import com.lederboard.backend.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service

public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public ResponseDTO registerUser(RequestDTO request) {

        // Валідація
        if(userRepository.existsByUserName(request.getUserName())) {
            throw new IllegalArgumentException("Username already exists");
        }

        if(userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        // Maпінг DTO в Entity
        User user = new User();
        user.setUserName(request.getUserName());
        user.setEmail(request.getEmail());
        user.setPasswordHash(request.getPassword()); // Хешування пізніше
        User savedUser = userRepository.save(user);

        // Maпінг Entity в DTO відповіді
        return ResponseDTO.builder()
                .id(savedUser.getId())
                .userName(savedUser.getUserName())
                .email(savedUser.getEmail())
                .build();
    }
}
