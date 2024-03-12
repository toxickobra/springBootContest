package com.prashant.cartservice.dtos;

import java.util.List;

import com.prashant.cartservice.models.Product;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class FakeStoreCartDto {
    private Long id;
    private Long userId;
    private String date;
    private List<Product> products;
}
