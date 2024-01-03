package com.ars.YouBuy.user.mapper;

import com.ars.YouBuy.user.dto.RoleResponse;
import com.ars.YouBuy.user.entity.Role;
import com.ars.YouBuy.user.model.RoleModel;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    public RoleModel entityToModel(Role role){
        return RoleModel.builder()
                .id(role.getId())
                .name(role.getName())
                .build();
    }

    public Role modelToEntity(RoleModel role){
        return Role.builder()
                .id(role.getId())
                .name(role.getName())
                .build();
    }

    public RoleModel dtoToModel(RoleResponse role){
        return RoleModel.builder()
                .id(role.getId())
                .name(role.getName())
                .build();
    }

    public RoleResponse modelToDto(RoleModel role){
        return RoleResponse.builder()
                .id(role.getId())
                .name(role.getName())
                .build();
    }

}
