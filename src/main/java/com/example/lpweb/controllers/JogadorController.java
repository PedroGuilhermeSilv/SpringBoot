package com.example.lpweb.controllers;

import com.example.lpweb.dtos.JogadorRecordDto;
import com.example.lpweb.dtos.TimeRecordDto;
import com.example.lpweb.models.JogadorModel;
import com.example.lpweb.models.TimeModel;
import com.example.lpweb.repositories.JogadorRepository;
import com.example.lpweb.repositories.TimeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.sql.Time;
import java.util.List;
import java.util.Optional;

@RestController
public class JogadorController {
    @Autowired
    JogadorRepository jogadorRepository;


    @PostMapping("/jogadores")
    public ResponseEntity<JogadorModel> saveJogador(@RequestBody @Valid JogadorRecordDto jogadorRecordDto){
        var jogadorModel = new JogadorModel();
        BeanUtils.copyProperties(jogadorRecordDto,jogadorModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(jogadorRepository.save(jogadorModel));
    }

    @GetMapping("/jogadores")
    public ResponseEntity<List<JogadorModel>> getAllJogador(){
        List<JogadorModel> jogadores = jogadorRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(jogadores);
    }
    @GetMapping("/jogadores/{id}")
    public ResponseEntity<Object> getOneJogador(@PathVariable(value = "id") Integer id){
        Optional<JogadorModel> jogador0 = jogadorRepository.findById(id);
        if(jogador0.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Jogador não encontrado");
        }
        return  ResponseEntity.status(HttpStatus.OK).body(jogador0.get());
    }

    @PutMapping("/jogadores/{id}")
    public ResponseEntity<Object> updateJogador(@PathVariable(value = "id") Integer id, @RequestBody @Valid JogadorRecordDto jogadorRecordDto){
        Optional<JogadorModel> jogador0 = jogadorRepository.findById(id);
        if(jogador0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Jogador não encontrado");
        }
        var jogadorModel = jogador0.get();
        // jogadorModel.setTime(jogador0.get().getTime());
        BeanUtils.copyProperties(jogadorRecordDto,jogadorModel);
        return ResponseEntity.status(HttpStatus.OK).body(jogadorRepository.save(jogadorModel));
    }
}
