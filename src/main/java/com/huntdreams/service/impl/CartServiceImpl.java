package com.huntdreams.service.impl;

import com.huntdreams.domain.Cart;
import com.huntdreams.domain.repository.CartRepository;
import com.huntdreams.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 购物车Service实现类
 * Created by noprom on 1/30/16.
 */
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    /**
     * 创建购物车
     * @param cart 购物车
     * @return 购物车
     */
    public Cart create(Cart cart) {
        return this.cartRepository.create(cart);
    }

    /**
     * 读取购物车内容
     * @param cartId 购物车id
     * @return 购物车
     */
    public Cart read(String cartId) {
        return this.cartRepository.read(cartId);
    }

    /**
     * 更新购物车内容
     * @param cartId 购物车id
     * @param cart 购物车
     */
    public void update(String cartId, Cart cart) {
        this.cartRepository.update(cartId, cart);
    }

    /**
     * 删除购物车
     * @param cartId 购物车id
     */
    public void delete(String cartId) {
        this.cartRepository.delete(cartId);
    }
}
