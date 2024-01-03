package com.ars.YouBuy.shopingcart.model;

import com.ars.YouBuy.shopingcart.entity.ShoppingCartItem;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor
@Builder
public class ShoppingCartModel {
    private Integer id;
    @Builder.Default
    private Set<ShoppingCartItem> items = new HashSet<>();
}
