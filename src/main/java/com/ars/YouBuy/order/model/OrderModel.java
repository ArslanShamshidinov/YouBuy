package com.ars.YouBuy.order.model;

import com.ars.YouBuy.order.entity.OrderItem;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor
@Builder
public class OrderModel {
    private Integer id;
    private ZonedDateTime created;
    private Integer userId;
    @Builder.Default
    private Set<OrderItem> items = new HashSet<>();
    private Integer shippingId;
}
