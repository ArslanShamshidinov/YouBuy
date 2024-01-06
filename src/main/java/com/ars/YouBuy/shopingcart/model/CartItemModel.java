package com.ars.YouBuy.shopingcart.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CartItemModel {
    private Integer id;
    private Integer quantity;
    private Integer productId;
}