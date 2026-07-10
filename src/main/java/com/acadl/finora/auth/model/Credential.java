package com.acadl.finora.auth.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "credentials")
@AllArgsConstructor
@NoArgsConstructor
public class Credential {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Email é um campo obrigatório!")
    @Column(nullable = false)
    private String email;

    @NotBlank(message = "A senha é um campo obrigatório!")
    @Column(nullable = false)
    private String hash_password;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
