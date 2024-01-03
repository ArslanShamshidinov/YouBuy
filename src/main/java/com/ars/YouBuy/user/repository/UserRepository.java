package com.ars.YouBuy.user.repository;

import com.ars.YouBuy.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
