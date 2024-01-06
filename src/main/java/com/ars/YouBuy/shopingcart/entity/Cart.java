package com.ars.YouBuy.shopingcart.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shopping_cart")
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created", nullable = false)
    private ZonedDateTime created;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "cart_item", joinColumns = @JoinColumn(name = "cart_id"), inverseJoinColumns = @JoinColumn(name = "card_item_id"))
    @Builder.Default
    private Set<CartItem> items = new HashSet<>();
}