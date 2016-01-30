package com.huntdreams.validator;

import com.huntdreams.domain.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.math.BigDecimal;


/**
 * UnitsInStockValidator
 * Created by noprom on 1/30/16.
 */
@Component
public class UnitsInStockValidator implements Validator {

    public boolean supports(Class<?> aClass) {
        return Product.class.isAssignableFrom(aClass);
    }

    public void validate(Object o, Errors errors) {
        Product product = (Product) o;
        if (product.getUnitPrice() != null
                && new BigDecimal(10000).compareTo(product.getUnitPrice()) <= 0
                && product.getUnitsInStock() > 99) {
            errors.rejectValue("unitsInStock", "com.huntdreams.validator.UnitsInStock.message");
        }
    }
}
