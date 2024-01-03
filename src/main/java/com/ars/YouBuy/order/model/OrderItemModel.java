package com.ars.YouBuy.order.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Builder
public class OrderItemModel {
    private Integer id;
    private Integer quantity;
    private BigDecimal price;
    private Integer productId;
}
