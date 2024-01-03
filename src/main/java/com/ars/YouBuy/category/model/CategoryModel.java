package com.ars.YouBuy.category.model;

import com.ars.YouBuy.user.enums.RoleName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class CategoryModel {
private Integer id;
private String name;
}
