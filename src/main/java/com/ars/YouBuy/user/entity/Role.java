package com.ars.YouBuy.user.entity;

import com.ars.YouBuy.user.enums.RoleName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "role")
@Getter
@AllArgsConstructor
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(name = "name", nullable = false , unique = true)
    private RoleName name;
}
