package com.ars.YouBuy.shopingcart.model;

import com.ars.YouBuy.shopingcart.entity.ShoppingCartItem;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@RequiredArgsConstructor
@Builder
public class ShoppingCartModel {
    @NonNull
    private Integer id;
    @NonNull
    private Set<ShoppingCartItem> items = new HashSet<>();
}
