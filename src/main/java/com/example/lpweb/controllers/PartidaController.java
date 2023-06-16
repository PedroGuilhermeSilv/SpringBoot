package com.example.lpweb.controllers;

import com.example.lpweb.dtos.CampeonatoRecordDto;
import com.example.lpweb.dtos.PartidaRecordDto;
import com.example.lpweb.dtos.TimeRecordDto;
import com.example.lpweb.models.CampeonatoModel;
import com.example.lpweb.models.PartidaModel;
import com.example.lpweb.models.TimeModel;
import com.example.lpweb.repositories.PartidaRepository;
import com.example.lpweb.repositories.ResultadoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PartidaController {
    @Autowired
    PartidaRepository partidaRepository;
    @Autowired
    ResultadoRepository resultadoRepository;

    @PostMapping("/partidas")
    public ResponseEntity<PartidaModel>savePartida(@RequestBody @Valid PartidaRecordDto partidaRecordDto){
        var partidaModel = new PartidaModel();
        BeanUtils.copyProperties(partidaRecordDto,partidaModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(partidaRepository.save(partidaModel));
    }
    @GetMapping("/partidas")
    public ResponseEntity<List<PartidaModel>> getAllPartidas(){
        List<PartidaModel> partidaModels = partidaRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(partidaModels);
    }
    @PutMapping("/partidas/{id}")
    public ResponseEntity<Object> updatePartida(@PathVariable(value = "id") Integer id, @RequestBody @Valid PartidaRecordDto partidaRecordDto){
        Optional<PartidaModel> partida0 = partidaRepository.findById(id);
        if(partida0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Partida não encontrado"+partida0.get().getResultado());
        }
        var partidaModel = partida0.get();



        BeanUtils.copyProperties(partidaRecordDto,partidaModel);

        return ResponseEntity.status(HttpStatus.OK).body(partidaRepository.save(partidaModel));
    }
    @GetMapping("/partidas/concluidas")
    public ResponseEntity<List<String>> getPartidasConcluidas(){
        List<PartidaModel> partida0 = partidaRepository.findAll();
        List<String> partidasJogadas = new ArrayList<>();
        if(partida0.isEmpty()){
            partidasJogadas.add("Não encontrado");
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(partidasJogadas);
        }

        for(int i=0 ; i<partida0.size(); i++){
            if(partida0.get(i).getResultado()!=null){
                partidasJogadas.add("Time Mandante: "+partida0.get(i).getTimeMandante().getNome()+" X Time Visitante: "+ partida0.get(i).getTimeVisitante().getNome()+" Resultado:"+ partida0.get(i).getResultado().getNumGolsMandante()+"-"+partida0.get(i).getResultado().getNumGolsVisitante());
            }

        }
        return  ResponseEntity.status(HttpStatus.OK).body(partidasJogadas);
    }
    @GetMapping("/partidas/pendentes")
    public ResponseEntity<List<String>> getPartidasPendentes(){
        List<PartidaModel> partida0 = partidaRepository.findAll();
        List<String> partidasJogadas = new ArrayList<>();
        if(partida0.isEmpty()){
            partidasJogadas.add("Não encontrado");
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(partidasJogadas);
        }

        for(int i=0 ; i<partida0.size(); i++){
            if(partida0.get(i).getResultado()==null){
                partidasJogadas.add("Time Mandante: "+partida0.get(i).getTimeMandante().getNome()+" X Time Visitante: "+ partida0.get(i).getTimeVisitante().getNome());
            }

        }
        return  ResponseEntity.status(HttpStatus.OK).body(partidasJogadas);
    }
}
