package com.example.lpweb.dtos;

import jakarta.validation.constraints.NotBlank;

public record EstadioRecordDto(@NotBlank String nome, @NotBlank String endereco) {
}
