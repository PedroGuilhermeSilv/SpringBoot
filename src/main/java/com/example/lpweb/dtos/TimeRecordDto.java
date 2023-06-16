package com.example.lpweb.dtos;

import com.example.lpweb.models.CampeonatoModel;
import com.example.lpweb.models.EstadioModel;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.Set;

public record TimeRecordDto(@NotBlank String nome, EstadioModel estadio) {
}
