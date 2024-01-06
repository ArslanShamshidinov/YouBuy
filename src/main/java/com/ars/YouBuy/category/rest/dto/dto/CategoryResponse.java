package com.ars.YouBuy.category.rest.dto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class CategoryResponse {
    private Integer id;
    private String name;
}
