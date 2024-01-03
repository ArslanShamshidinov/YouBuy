package com.ars.YouBuy.shopingcart.repository;

import com.ars.YouBuy.shopingcart.entity.ShoppingCartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItem,Integer> {
}
