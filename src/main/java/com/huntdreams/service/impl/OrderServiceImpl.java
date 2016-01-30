package com.huntdreams.service.impl;

import com.huntdreams.domain.Order;
import com.huntdreams.domain.Product;
import com.huntdreams.domain.repository.ProductRepository;
import com.huntdreams.domain.repository.OrderRepository;
import com.huntdreams.service.CartService;
import com.huntdreams.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by noprom on 1/22/16.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartService cartService;

    /**
     * 处理订单
     * @param productId
     * @param count
     */
    public void processOrder(String productId, int count) {
        Product productById = productRepository.getProductById(productId);
        if (productById.getUnitsInStock() < count) {
            throw new IllegalArgumentException("Out of Stock. Available Units in stock"+ productById.getUnitsInStock());
        }
        productById.setUnitsInStock(productById.getUnitsInStock() - count);
    }

    /**
     * 保存订单
     * @param order
     * @return
     */
    public Long saveOrder(Order order) {
        Long orderId = orderRepository.saveOrder(order);
        cartService.delete(order.getCart().getCartId());
        return orderId;
    }
}
