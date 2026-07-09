package com.acadl.finora.auth.controller;

import com.acadl.finora.auth.dto.RegisterRequest;
import com.acadl.finora.auth.model.User;
import com.acadl.finora.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

}