package com.prashant.cartservice.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prashant.cartservice.models.Cart;
import com.prashant.cartservice.services.CartService;



@RestController
public class CartController {
    private CartService cartService;

    CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/carts")
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }
    @GetMapping("/carts/{id}")
    public Cart getSingleCart(@PathVariable Long id) {
        System.out.println("entered");
        return cartService.getCartById(id);
    }
    @GetMapping("/carts?startDate={startDate}&endDate={endDate}")
    public List<Cart> getCartInDataRange(@PathVariable String startDate, @PathVariable String endDate) {
        return cartService.getCartInDataRange(startDate, endDate);
    }
    @GetMapping("carts/user/{userId}")
    public Cart getCartByUserId(@PathVariable Long userId) {
        return cartService.getCartByUserId(userId);
    }
    @PostMapping("/carts")
    public Cart addCart(@RequestBody Cart cart) {
        return cartService.addCart(cart);
    }
    @PatchMapping("/carts/{id}")
    public Cart updateCart(@PathVariable Long id, @RequestBody Cart cart) {
        return cartService.updateCart(id, cart);
    }
    @PutMapping("/carts/{id}")
    public Cart replaceCart(@PathVariable Long id, @RequestBody Cart cart) {
        return cartService.replaceCart(id, cart);
    }
    @DeleteMapping("/carts/{id}")
    public void deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
    }
}
