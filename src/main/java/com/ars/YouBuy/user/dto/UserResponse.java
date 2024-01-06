package com.ars.YouBuy.user.dto;

import com.ars.YouBuy.user.entity.Role;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Getter
@Builder
public class UserResponse {

    private Integer id;

    private ZonedDateTime created;

    private String name;

    private String surname;

    private String email;

    private String password;
    @Builder.Default
    private Set<Role> roles = new HashSet<>();
}
