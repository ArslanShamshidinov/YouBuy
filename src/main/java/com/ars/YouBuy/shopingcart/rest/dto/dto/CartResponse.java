package com.ars.YouBuy.shopingcart.rest.dto.dto;

import com.ars.YouBuy.shopingcart.entity.CartItem;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor
@Builder
public class CartResponse {
    private Integer id;
    private ZonedDateTime created;
    @Builder.Default
    private Set<CartItem> items = new HashSet<>();
}
