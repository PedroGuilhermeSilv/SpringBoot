package com.example.lpweb.dtos;

import com.example.lpweb.models.PartidaModel;
import jakarta.validation.constraints.NotNull;

public record ResultadoRecordDto( Integer numGolsMandante,Integer numGolsVisitante,Integer idPartida) {
}
