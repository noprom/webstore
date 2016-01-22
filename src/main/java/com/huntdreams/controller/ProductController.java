package com.huntdreams.controller;

import com.huntdreams.domain.Product;
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


    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String list(Model model) {
        Product iphone = new Product("P1234","iPhone 5s", new
                BigDecimal(500));
        iphone.setDescription("Apple iPhone 5s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera");
                iphone.setCategory("Smart Phone");
        iphone.setManufacture("Apple");
        iphone.setUnitsInStock(1000);
        model.addAttribute("product", iphone);
        return "products";
    }
}
