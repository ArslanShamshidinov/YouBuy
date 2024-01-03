package com.ars.YouBuy.shipping.repository;

import com.ars.YouBuy.shipping.entity.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingRepository extends JpaRepository<Shipping, Integer> {
}
