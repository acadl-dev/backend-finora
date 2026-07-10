package com.acadl.finora.auth.controller;
import com.acadl.finora.auth.dto.RegisterDTO;
import com.acadl.finora.auth.service.CredentialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final CredentialService authService;

    @PostMapping("/register") //retirar o patch desnecessario
    public ResponseEntity<RegisterDTO> registerNewUser(@RequestBody RegisterDTO registerDTO) {
        RegisterDTO registeredUser = authService.registerNewUser(registerDTO);
        return ResponseEntity.status(HttpStatus.OK).body(registeredUser);
    }

}