package com.ars.YouBuy.order.repository;

import com.ars.YouBuy.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
