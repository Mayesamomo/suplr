package com.m.s.Controller;


import com.m.s.Models.Provider;
import com.m.s.Repository.ProviderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProviderController {

    @Autowired
    ProviderRepo providerRepo;


    @GetMapping("providerMenu")
    public String getProvider (/*Model model*/) {

        /*Provider provider = new Provider();

        model.addAttribute("product", provider);

         */

        return "providerMenu";


    }

    @GetMapping("addProviderForm")
    public String getAddProviderHtml (Model model) {
        Provider provider = new Provider();

        model.addAttribute("provider", provider);
        return "addProviderForm";
    }

    @PostMapping("addProvider")
    public String addProvider (@ModelAttribute( "provider") Provider provider) {

        try {

            //model.addAttribute("provider", provider);

            providerRepo.save(provider);

        }catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());

        }

        return "ProviderMenu";
    }

    @GetMapping("showProvidersHtml")
    public String getProvidersHtml(Model model) {

        Provider provider = new Provider();

        model.addAttribute("provider", provider);

        return "showProvidersHtml";
    }


     @GetMapping("showProviders")
     public List<Provider> ShowProviders(Model model) {

        List<Provider> providers = new ArrayList<>();

        ModelAndView mv = new ModelAndView();

        providers = providerRepo.findAll();

        if (providers.size()==0) {
            providers = new ArrayList<>();
        }

        mv.addObject("providerList", providers);

         return providers;
    }






}
