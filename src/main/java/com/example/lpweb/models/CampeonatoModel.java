package com.example.lpweb.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jdk.jfr.Enabled;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "TB_CAMPEONATO")
public class CampeonatoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_campeonato_seq")
    @SequenceGenerator(name = "tb_campeonato_seq", sequenceName = "tb_campeonato_seq", allocationSize = 1)
    private Integer id;

    private Integer ano;
    private String nome;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "TB_CAMPEONATO_TIME",
            joinColumns = @JoinColumn(name = "campeonato_id"),
            inverseJoinColumns = @JoinColumn(name = "time_id")
    )
    private List<TimeModel> times;
    @OneToMany(mappedBy = "campeonato")
    @JsonIgnore
    private List<PartidaModel> partidas;

    public List<PartidaModel> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<PartidaModel> partidas) {
        this.partidas = partidas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<TimeModel> getTimes() {
        return times;
    }

    public void setTimes(List<TimeModel> times) {

        this.times = times;
    }
}
