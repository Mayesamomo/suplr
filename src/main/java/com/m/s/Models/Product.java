package com.m.s.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

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
    private Long producId;
    @NotBlank(message = " Name cannot be empty or Null")
    private String productName;
    @NotBlank(message = "enter price.")
    private Double price;
    @Nullable
    private String imageurl;
    @Nullable
    @Lob
    private String description;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "providerId", referencedColumnName = "providerId")
    private Provider provider;
    private Instant createdDate;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
    private Category category;
}
