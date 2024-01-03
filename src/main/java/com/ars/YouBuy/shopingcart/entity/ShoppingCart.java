package com.ars.YouBuy.shopingcart.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shopping_cart")
@RequiredArgsConstructor
@Builder
@Getter
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Integer id;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "cart_item", joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    @NonNull
    private Set<ShoppingCartItem> items = new HashSet<>();
}