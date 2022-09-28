package com.demo.ecommerce.controller;

import com.demo.ecommerce.model.Category;
import com.demo.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/admin")
    public String adminHome() {
        return "adminHome";
    }


    @GetMapping("/admin/categories")
    public String adminCategories(Model model) {
        model.addAttribute("categories",categoryService.getAllCategories());
        return "categories";
    }

    @GetMapping("/admin/categories/add")
    public String adminAddCategories(Model model) {
        model.addAttribute("category", new Category());
        return "categoriesAdd";
    }

    @PostMapping("/admin/categories/add")
    public String adminAddCategories(@ModelAttribute("category") Category category) {
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }

}
