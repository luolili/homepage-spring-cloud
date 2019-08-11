package com.homepage.service;

import com.homepage.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Product getProductById(String productId);
}
