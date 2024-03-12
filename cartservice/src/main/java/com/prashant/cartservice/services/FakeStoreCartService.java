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
    

    //implement the methods from the CartService interface
    public List<Cart> getAllCarts() {
        FakeStoreCartDto[] cartDtos = restTemplate.getForObject("https://fakestoreapi.com/carts", FakeStoreCartDto[].class);
        Cart[] carts = new Cart[cartDtos.length];
        for (int i = 0; i < cartDtos.length; i++) {
            carts[i] = new Cart();
            // [
            //     {
            //         id:1,
            //         userId:1,
            //         date:2020-10-10,
            //         products:[{productId:2,quantity:4},{productId:1,quantity:10},{productId:5,quantity:2}]
            //     },
            //     /*...*/
            //     {
            //         id:20,
            //         userId:10,
            //         date:2019-10-10,
            //         products:[{productId:1,quantity:5},{productId:5,quantity:1}]
            //     }
            // ] this is the format of the data from the fakestoreapi
            carts[i].setId(cartDtos[i].getId());
            carts[i].setUserId(cartDtos[i].getUserId());
            carts[i].setDate(cartDtos[i].getDate());
            carts[i].setProduct(cartDtos[i].getProducts());

        }
        return Arrays.asList(carts);
    }
    public Cart getCartById(Long id) {
        // {
        //     id:5,
        //     userId:1,
        //     date:...,
        //     products:[...]
        // } this is the format of the data from the fakestoreapi
        FakeStoreCartDto cartDto = restTemplate.getForObject("https://fakestoreapi.com/carts/"+id, FakeStoreCartDto.class);
        Cart cart = new Cart();
        cart.setId(cartDto.getId());
        cart.setUserId(cartDto.getUserId());
        cart.setDate(cartDto.getDate());
        cart.setProduct(cartDto.getProducts());
        return cart;
    }
    public Cart addCart(Cart cart) {
        // {
        //     id:21
        //     userId:5,
        //     date:2020-02-03,
        //     products:[{productId:5,quantity:1},{productId:1,quantity:5}]
        // }this is the format of the data from the fakestoreapi
        FakeStoreCartDto cartDto = restTemplate.getForObject("https://fakestoreapi.com/carts", FakeStoreCartDto.class);
        Cart newCart = new Cart();
        newCart.setId(cartDto.getId());
        newCart.setUserId(cartDto.getUserId());
        newCart.setDate(cartDto.getDate());
        newCart.setProduct(cartDto.getProducts());
        return newCart;
    }
    public Cart updateCart(Long id, Cart cart) {
        FakeStoreCartDto cartDto = restTemplate.getForObject("https://fakestoreapi.com/carts/"+id, FakeStoreCartDto.class);
        Cart updatedCart = new Cart();
        // {
        //     id:7,
        //     userId:3,
        //     date:2019-12-10,
        //     products:[{productId:1,quantity:3}]
        // }this is the format of the data from the fakestoreapi this may have some parameter or not
        updatedCart.setId(cartDto.getId());
        updatedCart.setUserId(cartDto.getUserId());
        updatedCart.setDate(cartDto.getDate());
        updatedCart.setProduct(cartDto.getProducts());
        return updatedCart;
    }
    public Cart replaceCart(Long id, Cart cart) {
        FakeStoreCartDto cartDto = restTemplate.getForObject("https://fakestoreapi.com/carts/"+id, FakeStoreCartDto.class);
        Cart replacedCart = new Cart();
        // {
        //     id:7,
        //     userId:3,
        //     date:2019-12-10,
        //     products:[{productId:1,quantity:3}]
        // }this is the format of the data from the fakestoreapi this may have some parameter or not
        replacedCart.setId(cartDto.getId());
        replacedCart.setUserId(cartDto.getUserId());
        replacedCart.setDate(cartDto.getDate());
        replacedCart.setProduct(cartDto.getProducts());
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
            // [
            //     {
            //         id:1,
            //         userId:1,
            //         date:2020-10-10,
            //         products:[{productId:2,quantity:4},{productId:1,quantity:10},{productId:5,quantity:2}]
            //     },
            //     /*...*/
            //     {
            //         id:20,
            //         userId:10,
            //         date:2019-10-10,
            //         products:[{productId:1,quantity:5},{productId:5,quantity:1}]
            //     }
            // ] this is the format of the data from the fakestoreapi
            carts[i].setId(cartDtos[i].getId());
            carts[i].setUserId(cartDtos[i].getUserId());
            carts[i].setDate(cartDtos[i].getDate());
            carts[i].setProduct(cartDtos[i].getProducts());

        }
        return Arrays.asList(carts);
    }
    public Cart getCartByUserId(Long userId) {
        FakeStoreCartDto cartDto = restTemplate.getForObject("https://fakestoreapi.com/carts/user/"+userId, FakeStoreCartDto.class);
        Cart cart = new Cart();
        cart.setId(cartDto.getId());
        cart.setUserId(cartDto.getUserId());
        cart.setDate(cartDto.getDate());
        cart.setProduct(cartDto.getProducts());
        return cart;
    }
}
