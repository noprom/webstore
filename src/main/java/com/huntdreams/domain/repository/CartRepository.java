package com.huntdreams.domain.repository;

import com.huntdreams.domain.Cart;

/**
 * 购物车接口
 * Created by noprom on 1/30/16.
 */
public interface CartRepository {
    Cart create(Cart cart);
    Cart read(String cartId);
    void update(String cartId, Cart cart);
    void delete(String cartId);
}
