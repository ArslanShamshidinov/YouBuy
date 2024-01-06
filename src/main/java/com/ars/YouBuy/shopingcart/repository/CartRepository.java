package com.ars.YouBuy.shopingcart.repository;

import com.ars.YouBuy.shopingcart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
}
