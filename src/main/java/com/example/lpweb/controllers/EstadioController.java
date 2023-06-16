package com.example.lpweb.controllers;

import com.example.lpweb.dtos.EstadioRecordDto;
import com.example.lpweb.models.EstadioModel;
import com.example.lpweb.models.JogadorModel;
import com.example.lpweb.repositories.EstadioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EstadioController {
    @Autowired
    EstadioRepository estadioRepository;

    @PostMapping("/estadios")
    public ResponseEntity<EstadioModel> saveEstadio(@RequestBody @Valid EstadioRecordDto estadioRecordDto){
        var estadioModel = new EstadioModel();
        BeanUtils.copyProperties(estadioRecordDto,estadioModel);

       return ResponseEntity.status(HttpStatus.CREATED).body(estadioRepository.save(estadioModel));
    }

    @GetMapping("/estadios")
    public ResponseEntity<List<EstadioModel>> getAllEstadios(){
        List<EstadioModel> estadios = estadioRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(estadios);
    }
}
