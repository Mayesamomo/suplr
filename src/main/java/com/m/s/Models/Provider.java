package com.m.s.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Provider {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long providerId;

    @NotBlank(message = "name is required")
    @Column(length = 50)
    private String name;

    @Lob
    @Column(length = 100)
    private String description;

    @Email
    @Column(length = 50)
    private String email;

    @Column(length = 9)
    private int phone;

    @Nullable
    @Column(length = 150)
    private String imageUrl;

    @ManyToMany(fetch = LAZY,mappedBy = "provider")
    private List<Product> product = new ArrayList<>();

    @ManyToMany()
    private List<User> user = new ArrayList<>();


}
