package com.ars.YouBuy.order.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "order")
@Getter
@RequiredArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Integer id;

    @NonNull
    @Column(name = "created", nullable = false)
    private ZonedDateTime created;

    @NonNull
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "order_items",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    @NonNull
    private Set<OrderItem> items = new HashSet<>();

    @NonNull
    @Column(name = "shipping_id", nullable = false)
    private Integer shippingId;

}