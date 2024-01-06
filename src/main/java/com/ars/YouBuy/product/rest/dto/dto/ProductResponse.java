package com.ars.YouBuy.product.rest.dto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@Builder
public class ProductResponse {
    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer categoryId;
    private String imageUrl;
}
