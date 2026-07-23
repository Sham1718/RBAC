package com.RBAC.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String name;
    @NotBlank @Column(unique = true)
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;
    @NotBlank
    @Enumerated (EnumType.STRING)
    private AuthProvider provider;
    @NotBlank
    private boolean enabled;
    private LocalDateTime createdAt;


    @PrePersist
    public void prePersist(){
        createdAt=LocalDateTime.now();
    }
}
