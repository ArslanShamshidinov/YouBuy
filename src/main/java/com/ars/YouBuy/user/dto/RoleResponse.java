package com.ars.YouBuy.user.dto;

import com.ars.YouBuy.user.enums.RoleName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

    @Getter
    @AllArgsConstructor
    @Builder
public class RoleResponse {
        private Integer id;
        private RoleName name;
}
