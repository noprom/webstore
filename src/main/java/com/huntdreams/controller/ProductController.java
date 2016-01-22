package com.huntdreams.controller;

import com.huntdreams.domain.Product;
import com.huntdreams.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;

/**
 * Created by noprom on 1/22/16.
 */
@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("products", productRepository.getAllProducts());
        return "products";
    }
}
