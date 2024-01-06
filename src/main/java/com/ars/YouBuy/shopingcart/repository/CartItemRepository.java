package com.ars.YouBuy.shopingcart.repository;

import com.ars.YouBuy.shopingcart.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
}
