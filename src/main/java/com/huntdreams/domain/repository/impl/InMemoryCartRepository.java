package com.huntdreams.domain.repository.impl;

import com.huntdreams.domain.Cart;
import com.huntdreams.domain.repository.CartRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * 购物车实现类
 * Created by noprom on 1/30/16.
 */
@Repository
public class InMemoryCartRepository implements CartRepository {

    /**
     * 购物车列表
     */
    private Map<String, Cart> listOfCarts;


    public InMemoryCartRepository() {
        listOfCarts = new HashMap<String,Cart>();
    }

    /**
     * 创建购物车
     * @param cart 购物车
     * @return 购物车
     */
    public Cart create(Cart cart) {
        if (listOfCarts.keySet().contains(cart.getCartId())) {
            throw new IllegalArgumentException(String.format("Can not create a cart. A cart with the give id (%) aldrady exist",cart.getCartId()));
        }
        listOfCarts.put(cart.getCartId(), cart);
        return cart;
    }

    /**
     * 读取购物车
     * @param cartId 购物车id
     * @return 购物车
     */
    public Cart read(String cartId) {
        return listOfCarts.get(cartId);
    }

    /**
     * 更新购物车
     * @param cartId 购物车id
     * @param cart 购物车
     */
    public void update(String cartId, Cart cart) {
        if (!listOfCarts.keySet().contains(cartId)) {
            throw new IllegalArgumentException(String.format("Can not update cart. The cart with the give id (%) does not does not exist",cartId));
        }
        listOfCarts.put(cartId, cart);
    }

    /**
     * 删除指定购物车
     * @param cartId 购物车id
     */
    public void delete(String cartId) {
        if (!listOfCarts.keySet().contains(cartId)) {
            throw new IllegalArgumentException(String.format("Can not delete cart. The cart with the give id (%) does not does not exist",cartId));
        }
        listOfCarts.remove(cartId);
    }
}
