package br.com.fiap.mygym.split.dto;

import br.com.fiap.mygym.split.Split;

public record SplitRequest(
    String name,
    String type,
    String description
) {
    public Split toModel() {
        return Split.builder()
            .name(name)
            .type(type)
            .description(description)
            .build();
    }
}
