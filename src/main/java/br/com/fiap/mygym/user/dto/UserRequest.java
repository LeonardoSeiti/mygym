package br.com.fiap.mygym.user.dto;

import java.time.LocalDateTime;
import br.com.fiap.mygym.user.User;

public record UserRequest(
    String name,
    String gym,
    String email,
    String password,
    String split
) {
    public User toModel(){
        return User.builder()
            .name(name)
            .gym(gym)
            .email(email)
            .password(password)
            .split(split)
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .build();
    }
}
