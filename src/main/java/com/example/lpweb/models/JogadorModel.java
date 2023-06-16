package com.example.lpweb.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name="TB_JOGADOR")
public class JogadorModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_jogador_seq")
    @SequenceGenerator(name = "tb_jogador_seq", sequenceName = "tb_jogador_seq", allocationSize = 1)
    private Integer id;
    private String nome;
    private LocalDate dataNascimento;
    private Float altura;

    @ManyToOne
    @JoinColumn(name = "time_id")
    @JsonBackReference
    private TimeModel time;

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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public TimeModel getTime() {
        return time;
    }

    public void setTime(TimeModel time) {
        this.time = time;
    }
}
