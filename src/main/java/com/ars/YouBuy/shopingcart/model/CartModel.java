package com.ars.YouBuy.shopingcart.model;

import com.ars.YouBuy.shopingcart.entity.CartItem;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CartModel {
    private Integer id;
    private ZonedDateTime created;
    @Builder.Default
    private Set<CartItem> items = new HashSet<>();
}
