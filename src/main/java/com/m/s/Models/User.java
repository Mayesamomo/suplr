package com.m.s.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long userId;

    @NotBlank(message = "name is required")
    @Column(length = 50)
    private String name;

    @NotBlank(message = "Password is required")
    @Column(length = 50)
    private String password;

    @NotBlank(message = "passwordConfirmation is required")
    @Column(length = 50)
    private String passwordConfirmation;

    @Email
    @NotEmpty(message = "Email is required")
    @Column(length = 50)
    private String email;

    @Nullable
    @Column(length = 150)
    private String imageUrl;

    @NotNull()
    private Instant createdDate;

    private boolean enabled;

    @ManyToMany(mappedBy = "user")
    private List<Provider> provider = new ArrayList<>();
}
