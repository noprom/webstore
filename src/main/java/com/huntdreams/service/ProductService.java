package com.huntdreams.service;

import com.huntdreams.domain.Product;
import sun.plugin2.main.client.ProcessUI;

import java.util.List;

/**
 * Created by noprom on 1/24/16.
 */
public interface ProductService {
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    Product getProductById(String productID);
}
