package com.example.lpweb.controllers;

import com.example.lpweb.dtos.CampeonatoRecordDto;
import com.example.lpweb.dtos.EstadioRecordDto;
import com.example.lpweb.dtos.JogadorRecordDto;
import com.example.lpweb.models.CampeonatoModel;
import com.example.lpweb.models.EstadioModel;
import com.example.lpweb.models.JogadorModel;
import com.example.lpweb.models.TimeModel;
import com.example.lpweb.repositories.CampeonatoRepository;
import com.example.lpweb.repositories.TimeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CampeonatoController {
    @Autowired
    CampeonatoRepository campeonatoRepository;

    @PostMapping("/campeonatos")
    public ResponseEntity<CampeonatoModel> saveCampeonato(@RequestBody @Valid CampeonatoRecordDto campeonatoRecordDto){
        var campeonatoModel = new CampeonatoModel();
       // List<TimeModel> times = campeonatoModel.getTimes();
      //  campeonatoModel.setTimes(times);
        BeanUtils.copyProperties(campeonatoRecordDto,campeonatoModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(campeonatoRepository.save(campeonatoModel));
    }

    @GetMapping("/campeonatos")
    public ResponseEntity<List<CampeonatoModel>> getAllCampeonatos(){
        List<CampeonatoModel> campeonatoModels = campeonatoRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(campeonatoModels);
    }
    @GetMapping("/campeonatos/{id}")
    public ResponseEntity<Object> getOneCampeonato(@PathVariable(value = "id") Integer id){
        Optional<CampeonatoModel> campeonato0 = campeonatoRepository.findById(id);
        if(campeonato0.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Campeonato não encontrado");
        }
        return  ResponseEntity.status(HttpStatus.OK).body(campeonato0.get());
    }

//    Esta função irá retornar os times de determinado campeonato, isso dependerá do id do campeonato que vc mandar
    @GetMapping("/campeonatos/{id}/time")
    public ResponseEntity<List<String>> getTimesCampeonato(@PathVariable(value = "id") Integer id){
        Optional<CampeonatoModel> campeonato0 = campeonatoRepository.findById(id);
        List<String> times = new ArrayList<>();
        if(campeonato0.isEmpty()){
            times.add("Não encontrado");
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(times);
        }
        times.add("Campeonato: "+campeonato0.get().getNome());

        for(int i=0 ; i<campeonato0.get().getTimes().size(); i++){
            times.add(campeonato0.get().getTimes().get(i).getNome());
        }
        return  ResponseEntity.status(HttpStatus.OK).body(times);
    }
    @PutMapping("/campeonatos/{id}")
    public ResponseEntity<Object> updateCampeonato(@PathVariable(value = "id") Integer id, @RequestBody @Valid CampeonatoRecordDto campeonatoRecordDto){
        Optional<CampeonatoModel> campeonato0 = campeonatoRepository.findById(id);
        var campeonatoModel = campeonato0.get();
        if(campeonato0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Campeonato não encontrado");
        }

        BeanUtils.copyProperties(campeonatoRecordDto,campeonatoModel);
        return ResponseEntity.status(HttpStatus.OK).body(campeonatoRepository.save(campeonatoModel));

    }


}
