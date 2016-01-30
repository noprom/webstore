package com.huntdreams.domain.repository.impl;

import com.huntdreams.domain.Order;
import com.huntdreams.domain.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by noprom on 1/30/16.
 */
@Repository
public class InMemoryOrderRepositoryImpl implements OrderRepository {

    /**
     * 订单列表
     */
    private Map<Long, Order> listOfOrders;

    /**
     * 下一个订单id
     */
    private long nextOrderId;

    /**
     * 初始化
     */
    public InMemoryOrderRepositoryImpl() {
        listOfOrders = new HashMap<Long, Order>();
        nextOrderId = 1000;
    }

    /**
     * 保存订单
     *
     * @param order 订单
     * @return 订单ID
     */
    public Long saveOrder(Order order) {
        order.setOrderId(getNextOrderId());
        listOfOrders.put(order.getOrderId(), order);
        return order.getOrderId();
    }

    /**
     * 获得下一个订单id
     * @return 下个订单id
     */
    public synchronized long getNextOrderId() {
        return nextOrderId++;
    }
}