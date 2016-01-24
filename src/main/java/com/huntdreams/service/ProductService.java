package com.huntdreams.service;

import com.huntdreams.domain.Product;
import sun.plugin2.main.client.ProcessUI;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by noprom on 1/24/16.
 */
public interface ProductService {
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByManufacturer(String manufacturer);
    Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
    Set<Product> filterProducts(String category, String manufacture, Map<String, List<String>> filterParams);
    Product getProductById(String productID);
}
