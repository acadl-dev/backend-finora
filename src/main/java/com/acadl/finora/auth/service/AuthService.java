package com.acadl.finora.auth.service;

import com.acadl.finora.auth.dto.RegisterRequest;
import com.acadl.finora.auth.model.User;
import com.acadl.finora.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public User register(RegisterRequest request) {

        User user = new User();
        user.setNome(request.getNome());

        return userRepository.save(user);
    }
}