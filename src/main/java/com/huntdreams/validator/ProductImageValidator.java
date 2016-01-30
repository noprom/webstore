package com.huntdreams.validator;

import com.huntdreams.domain.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * ProductImageValidator
 * Created by noprom on 1/30/16.
 */
public class ProductImageValidator implements Validator {

    /**
     * 允许上传图片的大小
     */
    private long allowedSize;

    public void setAllowedSize(long allowedSize) {
        this.allowedSize = allowedSize;
    }

    /**
     * 校验Product这个类
     * @param aClass class
     * @return 是否校验
     */
    public boolean supports(Class<?> aClass) {
        return Product.class.isAssignableFrom(aClass);
    }

    /**
     * 校验规则
     * @param o 商品
     * @param errors 错误
     */
    public void validate(Object o, Errors errors) {
        Product product = (Product) o;
        if (product.getProductImage().getSize() >= allowedSize) {
            errors.rejectValue("productImage", "com.huntdreams.validator.ProductImage.message");
        }
    }
}
