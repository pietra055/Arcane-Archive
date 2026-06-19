package com.archivearcane.backend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Casa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String fundador;
    private String animalSimbolo;
    private String elemento;

    @OneToMany(mappedBy = "casa")
    @JsonManagedReference
    private List<Bruxo> bruxos = new ArrayList<>();

    public Casa() {
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

    public String getFundador() {
        return fundador;
    }

    public void setFundador(String fundador) {
        this.fundador = fundador;
    }

    public String getAnimalSimbolo() {
        return animalSimbolo;
    }

    public void setAnimalSimbolo(String animalSimbolo) {
        this.animalSimbolo = animalSimbolo;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public List<Bruxo> getBruxos() {
        return bruxos;
    }

    public void setBruxos(List<Bruxo> bruxos) {
        this.bruxos = bruxos;
    }
}