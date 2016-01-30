package com.huntdreams.service;

import com.huntdreams.domain.Order;

/**
 * Created by noprom on 1/22/16.
 */
public interface OrderService {
    void processOrder(String productId, int count);
//    public interface OrderRepository {
//        Long saveOrder(Order order);
//    }
}