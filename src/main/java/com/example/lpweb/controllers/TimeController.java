package com.example.lpweb.controllers;

import com.example.lpweb.dtos.JogadorRecordDto;
import com.example.lpweb.dtos.TimeRecordDto;
import com.example.lpweb.models.JogadorModel;
import com.example.lpweb.models.TimeModel;
import com.example.lpweb.repositories.TimeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class TimeController {
    @Autowired
    TimeRepository timeRepository;

    @PostMapping("/times")
    public ResponseEntity<TimeModel> saveTime(@RequestBody @Valid TimeRecordDto timeRecordDto) {
        var timeModel = new TimeModel();
        //timeModel.setNome(timeRecordDto.nome()); // Atribui o nome do time
       // TimeModel savedTime = timeRepository.save(timeModel);
        BeanUtils.copyProperties(timeRecordDto,timeModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(timeRepository.save(timeModel));
    }


    @GetMapping("/times")
    public ResponseEntity<List<TimeModel>> getAllTime(){
        List<TimeModel> times = timeRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(times);
    }
    @GetMapping("/times/{id}")
    public ResponseEntity<Object> getOneTime(@PathVariable(value = "id") Integer id){
        Optional<TimeModel> time0 = timeRepository.findById(id);
        if(time0.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Time não encontrado");
        }
        return  ResponseEntity.status(HttpStatus.OK).body(time0.get());
    }
    @PutMapping("/time/{id}")
    public ResponseEntity<Object> updateTime(@PathVariable(value = "id") Integer id, @RequestBody @Valid TimeRecordDto timeRecordDto){
        Optional<TimeModel> time0 = timeRepository.findById(id);
        if(time0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Jogador não encontrado");
        }
        var timeModel = time0.get();

        BeanUtils.copyProperties(timeRecordDto,timeModel);

        return ResponseEntity.status(HttpStatus.OK).body(timeRepository.save(timeModel));
    }
}
