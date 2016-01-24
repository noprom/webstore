package com.huntdreams.service.impl;

import com.huntdreams.domain.Product;
import com.huntdreams.domain.repository.ProductRepository;
import com.huntdreams.service.OrderService;
import com.huntdreams.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by noprom on 1/22/16.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.getProductsByCategory(category);
    }

    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        return productRepository.getProductsByFilter(filterParams);
    }

    public Product getProductById(String productID) {
        return productRepository.getProductById(productID);
    }
}
