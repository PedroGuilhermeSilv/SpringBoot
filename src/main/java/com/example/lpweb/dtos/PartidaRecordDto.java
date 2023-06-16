package com.example.lpweb.dtos;

import com.example.lpweb.models.CampeonatoModel;
import com.example.lpweb.models.ResultadoModel;
import com.example.lpweb.models.TimeModel;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PartidaRecordDto(@NotNull LocalDate data, TimeModel timeMandante, TimeModel timeVisitante, ResultadoModel resultado, CampeonatoModel campeonato) {
}
