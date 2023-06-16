package com.example.lpweb.dtos;

import com.example.lpweb.models.PartidaModel;
import com.example.lpweb.models.TimeModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Set;

public record CampeonatoRecordDto(@NotBlank String nome, @NotNull Integer ano,List<TimeModel> times,List<PartidaModel> partidas) {
}
