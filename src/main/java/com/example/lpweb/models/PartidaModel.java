package com.example.lpweb.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "TB_PARTIDA")
public class PartidaModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_partida_seq")
    @SequenceGenerator(name = "tb_partida_seq", sequenceName = "tb_partida_seq", allocationSize = 1)
    private Integer id;
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "campeonato_id")
//    @JsonBackReference
    private CampeonatoModel campeonato;
    @ManyToOne
    @JoinColumn(name = "time_mandante_id")

    private TimeModel timeMandante;

    @ManyToOne
    @JoinColumn(name = "time_visitante_id")
    private TimeModel timeVisitante;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_resultado")
    private ResultadoModel resultado;

    public ResultadoModel getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoModel resultado) {
        this.resultado = resultado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public CampeonatoModel getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(CampeonatoModel campeonato) {
        this.campeonato = campeonato;
    }

    public TimeModel getTimeMandante() {
        return timeMandante;
    }

    public void setTimeMandante(TimeModel timeMandante) {
        this.timeMandante = timeMandante;
    }

    public TimeModel getTimeVisitante() {
        return timeVisitante;
    }

    public void setTimeVisitante(TimeModel timeVisitante) {
        this.timeVisitante = timeVisitante;
    }


}
