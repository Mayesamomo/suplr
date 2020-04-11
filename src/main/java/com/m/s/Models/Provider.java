package com.m.s.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;
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
    private String providerName;
    @Lob
    @NotBlank(message = "Description is required")
    private String description;
    @Email
    @NotEmpty(message = "Email is required")
    private String email;
    @NotEmpty(message = "phone number is required")
    private Long phone;
    @OneToMany(fetch = LAZY)
    private List<Product> products;
    private Instant createdDate;

}
