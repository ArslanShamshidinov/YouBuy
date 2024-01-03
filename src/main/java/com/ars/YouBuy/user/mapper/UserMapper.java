package com.ars.YouBuy.user.mapper;

import com.ars.YouBuy.user.dto.UserResponse;
import com.ars.YouBuy.user.entity.User;
import com.ars.YouBuy.user.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserModel entityToModel(User user){
        return UserModel.builder()
                .id(user.getId())
                .created(user.getCreated())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRoles())
                .build();
    }

    public User modelToEntity(UserModel user){
        return User.builder()
                .id(user.getId())
                .created(user.getCreated())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRoles())
                .build();
    }

    public UserModel dtoToModel(UserResponse user){
        return UserModel.builder()
                .id(user.getId())
                .created(user.getCreated())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRoles())
                .build();
    }

    public UserResponse modelToDto(UserModel user){
        return UserResponse.builder()
                .id(user.getId())
                .created(user.getCreated())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRoles())
                .build();
    }


}
