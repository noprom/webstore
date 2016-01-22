package com.huntdreams.domain.repository;

import com.huntdreams.domain.Product;

import java.util.List;

/**
 * Created by noprom on 1/22/16.
 */
public interface ProductRepository {
    List<Product> getAllProducts();
}
