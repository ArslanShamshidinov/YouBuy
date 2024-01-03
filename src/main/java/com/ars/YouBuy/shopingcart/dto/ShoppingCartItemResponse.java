package com.ars.YouBuy.shopingcart.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ShoppingCartItemResponse {
    private Integer id;
    private Integer quantity;
    private Integer productId;
}
