package br.com.fiap.mygym.user.dto;

import br.com.fiap.mygym.user.User;

public record UserProfileResponse(
    String name,
    String gym,
    String email
) {
    public UserProfileResponse(User user){
        this(user.getName(), user.getGym(), user.getEmail());
    }
}
