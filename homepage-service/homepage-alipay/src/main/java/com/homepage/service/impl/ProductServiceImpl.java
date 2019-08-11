package com.homepage.service.impl;

import com.homepage.entity.Product;
import com.homepage.repo.ProductRepo;
import com.homepage.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(String productId) {
        return productRepo.getOne(productId);
    }
}
