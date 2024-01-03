package com.ars.YouBuy.shopingcart.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shopping_cart")
@AllArgsConstructor
@Builder
@Getter
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "cart_item", joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    @Builder.Default
    private Set<ShoppingCartItem> items = new HashSet<>();
}