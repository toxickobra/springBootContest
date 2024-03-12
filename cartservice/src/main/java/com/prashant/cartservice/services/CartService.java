package com.prashant.cartservice.services;

import java.util.List;

import com.prashant.cartservice.models.Cart;

public interface CartService {
    List<Cart> getAllCarts();
    Cart getCartById(Long id);
    Cart addCart(Cart cart);
    Cart updateCart(Long id, Cart cart);
    Cart replaceCart(Long id, Cart cart);
    void deleteCart(Long id);
    List<Cart> getCartInDataRange(String startDate, String endDate);
    Cart getCartByUserId(Long userId);
}
