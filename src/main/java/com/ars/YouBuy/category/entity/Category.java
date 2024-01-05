package com.ars.YouBuy.category.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "category")
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

}