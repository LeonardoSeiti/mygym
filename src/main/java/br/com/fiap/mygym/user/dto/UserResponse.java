package br.com.fiap.mygym.user.dto;

import java.time.LocalDateTime;

import br.com.fiap.mygym.user.User;

public record UserResponse(
    Long id,
    String name,
    String gym,
    String email,
    String split,
    LocalDateTime createdAt
) {
    public static UserResponse from(User user){
        return new UserResponse(
        user.getId(),
        user.getName(),
        user.getGym(), 
        user.getEmail(),
        user.getSplit(),
        user.getCreatedAt());
    }
}
