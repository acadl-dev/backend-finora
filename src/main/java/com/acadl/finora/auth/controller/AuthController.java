package com.acadl.finora.auth.controller;

import com.acadl.finora.auth.model.User;
import com.acadl.finora.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/create_user")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    @PostMapping
    public User createUser(@RequestBody User user){
        return userRepository.create(user);
    }

}


