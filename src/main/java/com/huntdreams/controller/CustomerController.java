package com.huntdreams.controller;

import com.huntdreams.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 用户控制器
 * Created by noprom on 1/22/16.
 */
@Controller
public class CustomerController {

    /**
     * 自动加载CustomerService
     */
    @Autowired
    private CustomerService customerService;

    /**
     * 用户列表
     * @param model model
     * @return 视图
     */
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers";
    }
}