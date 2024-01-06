package com.ars.YouBuy.shopingcart.rest.dto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class CartItemResponse {
    private Integer id;
    private Integer quantity;
    private Integer productId;
}
