package com.prashant.cartservice.models;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Product {
    // private Long id;
    // private String title;
    // private String description;
    // private double price;
    // private Category category;
    // private String imageUrl;
    // products:[{productId:1,quantity:3}] this is the format
    private Long productId;
    private int quantity;
}
