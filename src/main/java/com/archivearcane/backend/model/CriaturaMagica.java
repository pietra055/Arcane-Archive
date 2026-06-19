package com.archivearcane.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "criaturas_magicas")
public class CriaturaMagica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String categoria;
    private String periculosidade;
    private String habitat;

    public CriaturaMagica() {
    }

    public CriaturaMagica(Long id, String nome, String categoria, String periculosidade, String habitat) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.periculosidade = periculosidade;
        this.habitat = habitat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPericulosidade() {
        return periculosidade;
    }

    public void setPericulosidade(String periculosidade) {
        this.periculosidade = periculosidade;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }
}