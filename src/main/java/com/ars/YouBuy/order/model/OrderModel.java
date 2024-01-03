package com.ars.YouBuy.order.model;

import com.ars.YouBuy.order.entity.OrderItem;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@RequiredArgsConstructor
@Builder
public class OrderModel {
    @NonNull
    private Integer id;

    @NonNull
    private ZonedDateTime created;

    @NonNull
    private Integer userId;

    @NonNull
    private Set<OrderItem> items = new HashSet<>();

    @NonNull
    private Integer shippingId;
}
