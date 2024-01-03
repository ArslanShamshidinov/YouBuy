package com.ars.YouBuy.shopingcart.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ShoppingCartItemModel {
    private Integer id;
    private Integer quantity;
    private Integer productId;
}