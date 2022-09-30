package com.demo.ecommerce.service;

import com.demo.ecommerce.model.Category;
import com.demo.ecommerce.model.Product;
import com.demo.ecommerce.repository.CategoryRepository;
import com.demo.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public void addProduct(Product product) {
        productRepository.save(product);

    }

    public void removeProductById(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getAllProductsByCategoryId(int id) {
        return productRepository.findAllByCategory_Id(id);
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
}
