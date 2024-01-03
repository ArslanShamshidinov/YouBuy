package com.ars.YouBuy.shopingcart.dto;

import com.ars.YouBuy.shopingcart.entity.ShoppingCartItem;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@RequiredArgsConstructor
@Builder
public class ShoppingCartResponse {
    @NonNull
    private Integer id;
    @NonNull
    private Set<ShoppingCartItem> items = new HashSet<>();
}
