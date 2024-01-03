package com.ars.YouBuy.user.dto;

import com.ars.YouBuy.user.entity.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Getter
@Builder
public class UserResponse {
    @NonNull
    private Integer id;
    @NonNull
    private ZonedDateTime created;
    @NonNull
    private String name;
    @NonNull
    private String surname;
    @NonNull
    private String email;
    @NonNull
    private String password;
    @NonNull
    private Set<Role> roles = new HashSet<>();
}
