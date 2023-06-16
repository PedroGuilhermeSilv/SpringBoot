package com.example.lpweb.controllers;

import com.example.lpweb.dtos.ResultadoRecordDto;
import com.example.lpweb.dtos.TimeRecordDto;
import com.example.lpweb.models.PartidaModel;
import com.example.lpweb.models.ResultadoModel;
import com.example.lpweb.models.TimeModel;
import com.example.lpweb.repositories.ResultadoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResultadoController {
    @Autowired
    ResultadoRepository resultadoRepository;

    @PostMapping("/resultados")
    public ResponseEntity<ResultadoModel> saveResultado(@RequestBody @Valid ResultadoRecordDto resultadoRecordDto) {
        var resultadoModel = new ResultadoModel();
        BeanUtils.copyProperties(resultadoRecordDto,resultadoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(resultadoRepository.save(resultadoModel));
    }
    @GetMapping("/resultados")
    public ResponseEntity<List<ResultadoModel>> getAllResultados(){
        List<ResultadoModel> resultadoModels = resultadoRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(resultadoModels);
    }
}
