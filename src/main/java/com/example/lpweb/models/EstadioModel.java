package com.example.lpweb.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "TB_ESTADIO")
public class EstadioModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_estadio_seq")
    @SequenceGenerator(name = "tb_estadio_seq", sequenceName = "tb_estadio_seq", allocationSize = 1)
    private Integer id;
    private String nome;
    private  String endereco;

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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
