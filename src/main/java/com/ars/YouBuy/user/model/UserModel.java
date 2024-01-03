package com.ars.YouBuy.user.model;

import com.ars.YouBuy.user.entity.Role;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@RequiredArgsConstructor
@Builder
public class UserModel {
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
