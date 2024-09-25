package br.com.fiap.mygym.user.dto;

import br.com.fiap.mygym.user.User;

public record UserProfileResponse(
    String name,
    String gym,
    String email,
    String split
) {
    public UserProfileResponse(User user){
        this(user.getName(), user.getGym(), user.getEmail(), user.getSplit());
    }
}
