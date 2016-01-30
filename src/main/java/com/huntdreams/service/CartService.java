package com.huntdreams.service;

import com.huntdreams.domain.Cart;

/**
 * 购物车Service
 * Created by noprom on 1/30/16.
 */
public interface CartService {
    Cart create(Cart cart);
    Cart read(String cartId);
    void update(String cartId, Cart cart);
    void delete(String cartId);
    Cart validate(String cartId);
}