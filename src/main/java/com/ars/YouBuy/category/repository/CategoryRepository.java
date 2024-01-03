package com.ars.YouBuy.category.repository;

import com.ars.YouBuy.category.entity.Category;
import com.ars.YouBuy.user.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
