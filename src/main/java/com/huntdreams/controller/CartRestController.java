package com.huntdreams.controller;

import com.huntdreams.domain.Cart;
import com.huntdreams.domain.CartItem;
import com.huntdreams.domain.Product;
import com.huntdreams.exception.ProductNotFoundException;
import com.huntdreams.service.CartService;
import com.huntdreams.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * REST风格的购物车控制器
 * Created by noprom on 1/30/16.
 */
@Controller
@RequestMapping(value = "/rest/cart")
public class CartRestController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    /**
     * 创建一个购物车
     * @param cart 购物车
     * @return 购物车
     */
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Cart create(@RequestBody Cart cart) {
        return cartService.create(cart);
    }

    /**
     * 读取一个购物车的内容
     * @param cartId 购物车id
     * @return 购物车
     */
    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public @ResponseBody Cart read(@PathVariable(value = "cartId") String cartId) {
        return cartService.read(cartId);
    }

    /**
     * 删除一个购物车
     * @param cartId 购物车id
     */
    @RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "cartId") String cartId) {
        cartService.delete(cartId);
    }

    /**
     * 新增一个商品到购物车
     * @param productId 商品id
     * @param request request
     */
    @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable(value = "productId") String productId, HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        Cart cart = cartService.read(sessionId);
        if (cart == null) {
            cart = cartService.create(new Cart(sessionId));
        }

        Product product = productService.getProductById(productId);
        if (product == null) {
            throw new IllegalArgumentException(new ProductNotFoundException(productId));
        }
        cart.addCartItem(new CartItem(product));
        cartService.update(sessionId, cart);
    }

    /**
     * 删除一个商品
     * @param productId 商品ID
     * @param request request
     */
    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable String productId, HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        Cart cart = cartService.read(sessionId);
        if (cart == null) {
            cart = cartService.create(new Cart(sessionId));
        }

        Product product = productService.getProductById(productId);
        if (product == null) {
            throw new IllegalArgumentException(new ProductNotFoundException(productId));
        }
        cart.removeCartItem(new CartItem(product));
        cartService.update(sessionId, cart);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload")
    public void handleClientErrors(Exception e) {}

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal server error")
    public void handleServerErrors(Exception e) {}
}
