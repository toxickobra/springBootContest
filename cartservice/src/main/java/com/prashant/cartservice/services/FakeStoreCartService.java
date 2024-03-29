package com.prashant.cartservice.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prashant.cartservice.dtos.FakeStoreCartDto;
import com.prashant.cartservice.models.Cart;
@Service
public class FakeStoreCartService implements CartService{
    private RestTemplate restTemplate = new RestTemplate();
    public List<Cart> getAllCarts() {
        FakeStoreCartDto[] cartDtos = restTemplate.getForObject("https://fakestoreapi.com/carts", FakeStoreCartDto[].class);
        Cart[] carts = new Cart[cartDtos.length];
        for (int i = 0; i < cartDtos.length; i++) {
            carts[i] = new Cart();
            carts[i].setId(cartDtos[i].getId());
            carts[i].setUserId(cartDtos[i].getUserId());
            carts[i].setDate(cartDtos[i].getDate());
            carts[i].setProducts(cartDtos[i].getProducts());

        }
        return Arrays.asList(carts);
    }
    public Cart getCartById(Long id) {
        FakeStoreCartDto cartDto = restTemplate.getForObject("https://fakestoreapi.com/carts/"+id, FakeStoreCartDto.class);
        Cart cart = new Cart();
        cart.setId(cartDto.getId());
        cart.setUserId(cartDto.getUserId());
        cart.setDate(cartDto.getDate());
        cart.setProducts(cartDto.getProducts());
        return cart;
    }
    public Cart addCart(Cart cart) {
        FakeStoreCartDto cartDto = restTemplate.postForObject("https://fakestoreapi.com/carts", cart, FakeStoreCartDto.class);
        System.out.println(cartDto.getProducts());
        Cart newCart = new Cart();
        newCart.setId(cartDto.getId());
        newCart.setUserId(cartDto.getUserId());
        newCart.setDate(cartDto.getDate());
        newCart.setProducts(cartDto.getProducts());
        return newCart;
    }

public Cart updateCart(Long id, Cart cart) {
    FakeStoreCartDto cartDto = restTemplate.patchForObject("https://fakestoreapi.com/carts/" + id, cart, FakeStoreCartDto.class);
        System.out.println(cartDto.getProducts());
        Cart newCart = new Cart();
        newCart.setId(cartDto.getId());
        newCart.setUserId(cartDto.getUserId());
        newCart.setDate(cartDto.getDate());
        newCart.setProducts(cartDto.getProducts());
        return newCart;
}
    public Cart replaceCart(Long id, Cart cart) {
        restTemplate.put("https://fakestoreapi.com/carts/" + id, cart,FakeStoreCartDto.class);
    
        FakeStoreCartDto cartDto = restTemplate.getForObject("https://fakestoreapi.com/carts/" + id, FakeStoreCartDto.class);
    
        Cart replacedCart = new Cart();
        replacedCart.setId(cartDto.getId());
        replacedCart.setUserId(cartDto.getUserId());
        replacedCart.setDate(cartDto.getDate());
        replacedCart.setProducts(cartDto.getProducts());
    
        return replacedCart;
    }
    public void deleteCart(Long id) {
        restTemplate.delete("https://fakestoreapi.com/carts/"+id);
    }
    public List<Cart> getCartInDataRange(String startDate, String endDate) {
        FakeStoreCartDto[] cartDtos = restTemplate.getForObject("https://fakestoreapi.com/carts?startDate="+startDate+"&endDate="+endDate, FakeStoreCartDto[].class);
        Cart[] carts = new Cart[cartDtos.length];
        for (int i = 0; i < cartDtos.length; i++) {
            carts[i] = new Cart();
            carts[i].setId(cartDtos[i].getId());
            carts[i].setUserId(cartDtos[i].getUserId());
            carts[i].setDate(cartDtos[i].getDate());
            carts[i].setProducts(cartDtos[i].getProducts());

        }
        return Arrays.asList(carts);
    }
    public Cart getCartByUserId(Long userId) {
        FakeStoreCartDto cartDto = restTemplate.getForObject("https://fakestoreapi.com/carts/user/"+userId, FakeStoreCartDto.class);
        Cart cart = new Cart();
        cart.setId(cartDto.getId());
        cart.setUserId(cartDto.getUserId());
        cart.setDate(cartDto.getDate());
        cart.setProducts(cartDto.getProducts());
        return cart;
    }
}
