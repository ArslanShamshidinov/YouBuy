package com.ars.YouBuy.shopingcart.dto;

import com.ars.YouBuy.shopingcart.entity.ShoppingCartItem;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor
@Builder
public class ShoppingCartResponse {
    private Integer id;
    @Builder.Default
    private Set<ShoppingCartItem> items = new HashSet<>();
}
