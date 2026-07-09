package com.acadl.finora.auth.dto;

import lombok.Data;

@Data
public class RegisterRequest {

    private String nome;
    private String email;
    private String password;

}
