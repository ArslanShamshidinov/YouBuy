package com.ars.YouBuy.user.model;

import com.ars.YouBuy.user.enums.RoleName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class RoleModel {
    private Integer id;
    private RoleName name;
}
