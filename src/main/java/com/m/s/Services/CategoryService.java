package com.m.s.Services;

import com.m.s.Exceptions.CategoryException;
import com.m.s.Models.Category;
import com.m.s.Repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepository;

    public List<Category> listAll() {
        return categoryRepository.findAll();
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public Category get(long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new CategoryException("No Category found with ID - " + id));
        return categoryRepository.findById(id).get();
    }
}
