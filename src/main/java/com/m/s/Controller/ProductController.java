package com.m.s.Controller;

import com.m.s.Models.Product;
import com.m.s.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

@Controller
public class ProductController {

    @Autowired
    ProductRepo productRepo;

    @PostMapping("/addProduct")
    public Product addProduct(Product product) {

        try {

            //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:MM").withZone(ZoneId.systemDefault());

            product.setCreatedDate(Instant.now());

            productRepo.save(product);

        }catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());

        }

        return product;
    }
}
