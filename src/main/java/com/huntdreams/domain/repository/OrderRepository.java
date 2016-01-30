package com.huntdreams.domain.repository;

import com.huntdreams.domain.Order;

/**
 * Created by noprom on 1/30/16.
 */
public interface OrderRepository {

    Long saveOrder(Order order);
}
