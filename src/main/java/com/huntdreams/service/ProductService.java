package com.huntdreams.service;

import com.huntdreams.domain.Product;

import java.util.List;

/**
 * Created by noprom on 1/24/16.
 */
public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(String productID);
}
