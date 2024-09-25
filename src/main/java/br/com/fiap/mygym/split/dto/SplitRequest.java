package br.com.fiap.mygym.split.dto;

import br.com.fiap.mygym.split.Split;
import br.com.fiap.mygym.user.User;

import java.time.LocalDateTime;

public record SplitRequest(
            String type,
            String description ){
    public Split toModel(User user){
        return Split
                .builder()
                .type(type)
                .description(description)
                .createdAt(LocalDateTime.now())
                .user(user)
                .build();

    }
}
