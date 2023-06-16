package com.example.lpweb.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "TB_RESULTADO")
public class ResultadoModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_resultado_seq")
    @SequenceGenerator(name = "tb_resultado_seq", sequenceName = "tb_resultado_seq", allocationSize = 1)
    private Integer id;
    private Integer idPartida;

    public Integer getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(Integer idPartida) {
        this.idPartida = idPartida;
    }

    private Integer numGolsMandante;
    private Integer numGolsVisitante;



    public Integer getId() {
        return idPartida;
    }

    public void setId(Integer id) {
        this.idPartida = id;
    }

    public Integer getNumGolsMandante() {
        return numGolsMandante;
    }

    public void setNumGolsMandante(Integer numGolsMandante) {
        this.numGolsMandante = numGolsMandante;
    }

    public Integer getNumGolsVisitante() {
        return numGolsVisitante;
    }

    public void setNumGolsVisitante(Integer numGolsVisitante) {
        this.numGolsVisitante = numGolsVisitante;
    }



}
