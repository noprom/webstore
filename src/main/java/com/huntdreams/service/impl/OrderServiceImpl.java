package com.huntdreams.service.impl;

import com.huntdreams.domain.Product;
import com.huntdreams.domain.repository.ProductRepository;
import com.huntdreams.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by noprom on 1/22/16.
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private ProductRepository productRepository;

    public void processOrder(String productId, int count) {
        Product productById = productRepository.getProductById(productId);
        if (productById.getUnitsInStock() < count) {
            throw new IllegalArgumentException("Out of Stock. Available Units in stock"+ productById.getUnitsInStock());
        }
        productById.setUnitsInStock(productById.getUnitsInStock() - count);
    }
}
