package com.m.s.Controller;

import com.m.s.Models.Category;
import com.m.s.Models.Product;
import com.m.s.Models.Provider;
import com.m.s.Repository.CategoryRepo;
import com.m.s.Repository.ProductRepo;
import com.m.s.Repository.ProviderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Instant;

@Controller
public class MainController {

    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    ProviderRepo providerRepo;
    @Autowired
    ProductRepo productRepo;

    @GetMapping("/")
    public String Login() {

        return "Login";
    }


    @PostMapping("addItem")
    public String addItem () {

        Provider provider = new Provider();
        Product product = new Product();
        Category category = new Category();



        try {

            category.setName("Electronic");

            product.setName("Ruedas");
            product.setDescription("2 tires");
            product.setPrice(120.00);
            product.setQuantity(2);
            product.setCreatedDate(Instant.now());
            product.setCategory(category);

            categoryRepo.save(category);

            productRepo.save(product);

            provider.setName("Yamaha");
            provider.setDescription("Llantas nuevas");
            provider.setEmail("yamaha@hotmail.com");
            provider.setPhone(695689652);

            product.getProvider().add(provider);

            provider.getProduct().add(product);

            providerRepo.save(provider);


        }catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());

        }

        return "addItem.html";
    }


}
