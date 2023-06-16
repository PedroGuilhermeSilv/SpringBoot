package com.example.lpweb.dtos;

import com.example.lpweb.models.TimeModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record JogadorRecordDto(@NotBlank String nome, @NotNull Float altura, @NotNull LocalDate dataNascimento,TimeModel time) {
}
