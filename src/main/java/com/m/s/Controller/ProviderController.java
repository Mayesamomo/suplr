package com.m.s.Controller;

import com.m.s.Models.Category;
import com.m.s.Models.Product;
import com.m.s.Models.Provider;
import com.m.s.Repository.ProductRepo;
import com.m.s.Repository.ProviderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProviderController {

    @Autowired
    ProviderRepo providerRepo;

    @PostMapping("addProvider")
    public Provider addProvider (Provider provider) {

        try {

            providerRepo.save(provider);

        }catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());

        }

        return provider;
    }


}
