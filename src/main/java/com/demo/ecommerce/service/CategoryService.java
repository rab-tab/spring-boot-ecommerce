package com.demo.ecommerce.service;

import com.demo.ecommerce.model.Category;
import com.demo.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public void addCategory(Category category) {
        categoryRepository.save(category);

    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
