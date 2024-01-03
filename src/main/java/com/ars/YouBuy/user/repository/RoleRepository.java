package com.ars.YouBuy.user.repository;

import com.ars.YouBuy.user.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
