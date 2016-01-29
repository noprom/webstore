package com.huntdreams.exception;

/**
 * Created by noprom on 1/29/16.
 */
public class ProductNotFoundException extends RuntimeException{

    private String productId;

    public ProductNotFoundException(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }
}
