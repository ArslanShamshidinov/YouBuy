package com.ars.YouBuy.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Builder
public class OrderItemResponse {
    private Integer id;
    private Integer quantity;
    private BigDecimal price;
    private Integer productId;
}
