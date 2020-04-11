package com.m.s.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long productId;

    @NotBlank(message = " Name cannot be empty or Null")
    @Column(length = 50)
    private String name;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private int quantity;

    @Nullable
    @Column(length = 150)
    private String imageUrl;

    @Nullable
    @Lob
    @Column(length = 100)
    private String description;

    @ManyToMany(fetch = LAZY)
    private List<Provider> provider = new ArrayList<>();

    @NotNull()
    private Instant createdDate;

    @ManyToOne(fetch = LAZY)
    private Category category;


}
