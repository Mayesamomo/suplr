package com.m.s.Controller;

import com.m.s.Models.Category;
import com.m.s.Models.Product;
import com.m.s.Repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.time.Instant;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepo categoryRepo;

    @PostMapping("addCategory")
    public Category addCategory(Category category) {
        ModelAndView mv = new ModelAndView();

        try {

            categoryRepo.save(category);

        }catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
        }
        //return "Added "+category+" correctly";
        return category;
    }
}
