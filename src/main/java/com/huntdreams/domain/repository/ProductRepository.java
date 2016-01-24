package com.huntdreams.domain.repository;

import com.huntdreams.domain.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by noprom on 1/22/16.
 */
public interface ProductRepository {
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    Product getProductById(String productId);
    Set<Product> getProductsByFilter(Map<String, List<String> > filterParams);
}
