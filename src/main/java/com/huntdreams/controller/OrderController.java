package com.huntdreams.controller;

import com.huntdreams.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 订单控制器
 * Created by noprom on 1/22/16.
 */
@Controller
public class OrderController {

    /**
     * 自动加载OrderService
     */
    @Autowired
    private OrderService orderService;

    /**
     * 伪处理订单
     * @return 跳转到商品列表
     */
    @RequestMapping(value = "/order/P1234/2", method = RequestMethod.GET)
    public String process() {
        orderService.processOrder("P1234", 2);
        return "redirect:/products";
    }
}