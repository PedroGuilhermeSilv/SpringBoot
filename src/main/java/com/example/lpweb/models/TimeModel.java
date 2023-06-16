package com.example.lpweb.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "TB_TIME")
public class TimeModel  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_time_seq")
    @SequenceGenerator(name = "tb_time_seq", sequenceName = "tb_time_seq", allocationSize = 1)
    private Integer id;
    private String nome;

    @OneToMany(mappedBy = "time")
    @JsonManagedReference
    private List<JogadorModel> jogadores;

    @OneToOne
    @JoinColumn(name = "estadio_id")
    private EstadioModel estadio;

    @ManyToMany(mappedBy = "times")
    @JsonIgnoreProperties("times")
    private List<CampeonatoModel> campeonatos;
    @OneToMany(mappedBy = "timeMandante")
    @JsonIgnore
    private List<PartidaModel> partidasMandantes;

    @OneToMany(mappedBy = "timeVisitante")
    @JsonIgnore
    private List<PartidaModel> partidasVisitantes;

    public List<PartidaModel> getPartidasMandantes() {
        return partidasMandantes;
    }

    public void setPartidasMandantes(List<PartidaModel> partidasMandantes) {
        this.partidasMandantes = partidasMandantes;
    }

    public List<PartidaModel> getPartidasVisitantes() {
        return partidasVisitantes;
    }

    public void setPartidasVisitantes(List<PartidaModel> partidasVisitantes) {
        this.partidasVisitantes = partidasVisitantes;
    }

    public List<CampeonatoModel> getCampeonatos() {
        return campeonatos;
    }

    public void setCampeonatos(List<CampeonatoModel> campeonatos) {
        this.campeonatos = campeonatos;
    }

    public EstadioModel getEstadio() {
        return estadio;
    }

    public void setEstadio(EstadioModel estadio) {
        this.estadio = estadio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<JogadorModel> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<JogadorModel> jogadores) {
        this.jogadores = jogadores;
    }
}
