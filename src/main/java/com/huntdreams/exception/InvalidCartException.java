package com.huntdreams.exception;

/**
 * 购物车异常处理类
 * Created by noprom on 1/30/16.
 */
public class InvalidCartException extends RuntimeException {

    private String cartId;//购物车id

    public InvalidCartException(String cartId) {
        this.cartId = cartId;
    }

    public String getCartId() {
        return cartId;
    }
}
