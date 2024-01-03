package com.ars.YouBuy.order.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "order")
@Getter
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;


    @Column(name = "created", nullable = false)
    private ZonedDateTime created;

    @NonNull
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "order_items",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    @Builder.Default
    private Set<OrderItem> items = new HashSet<>();

    @NonNull
    @Column(name = "shipping_id", nullable = false)
    private Integer shippingId;

}