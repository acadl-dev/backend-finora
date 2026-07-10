package com.acadl.finora.auth.service;
import com.acadl.finora.auth.model.Credential;
import com.acadl.finora.auth.model.User;
import com.acadl.finora.auth.repository.CredentialRepository;
import com.acadl.finora.auth.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthService {

    private final CredentialRepository credentialRepository;
    private final UserRepository userRepository;

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public AuthService(CredentialRepository credentialRepository, UserRepository userRepository) {
        this.credentialRepository = credentialRepository;
        this.userRepository = userRepository;
    }


    public Credential register(Credential credential) {
        User user = new User();
        user.setName("Test User");
        // id — o banco tem que gerar

        User savedUser = this.userRepository.save(user);

        credential.setUser(savedUser);
        credential.setHash_password(passwordEncoder().encode(credential.getHash_password()));

        return this.credentialRepository.save(credential);
    }
}


