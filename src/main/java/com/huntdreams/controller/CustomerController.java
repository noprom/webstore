package com.huntdreams.controller;

import com.huntdreams.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by noprom on 1/22/16.
 */
@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers";
    }
}
