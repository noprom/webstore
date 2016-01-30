package com.huntdreams.validator;

import com.huntdreams.domain.Product;
import com.huntdreams.exception.ProductNotFoundException;
import com.huntdreams.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by noprom on 1/30/16.
 */
public class ProductIdValidator implements ConstraintValidator<ProductId, String> {

    @Autowired
    private ProductService productService;

    public void initialize(ProductId productId) {

    }

    /**
     * 校验
     * @param value
     * @param constraintValidatorContext
     * @return
     */
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        Product product;
        try {
            product = productService.getProductById(value);
        } catch (ProductNotFoundException e) {
            return true;
        }
        if (product != null) {
            return false;
        }
        return true;
    }
}
