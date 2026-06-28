package com.archivearcane.backend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "casas")
public class Casa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String fundador;
    private String simbolo;
    private int pontuacao;

    @OneToMany(mappedBy = "casa", cascade = CascadeType.ALL)
    @JsonManagedReference("casa-bruxos")
    private List<Bruxo> bruxos = new ArrayList<>();

    @OneToMany(mappedBy = "casa", cascade = CascadeType.ALL)
    @JsonManagedReference("casa-criaturas")
    private List<CriaturaMagica> criaturasMagicas = new ArrayList<>();

    public Casa() {
    }

    public Casa(Long id, String nome, String fundador, String simbolo, int pontuacao) {
        this.id = id;
        this.nome = nome;
        this.fundador = fundador;
        this.simbolo = simbolo;
        this.pontuacao = pontuacao;
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

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public List<Bruxo> getBruxos() {
        return bruxos;
    }

    public void setBruxos(List<Bruxo> bruxos) {
        this.bruxos = bruxos;
    }

    public List<CriaturaMagica> getCriaturasMagicas() {
        return criaturasMagicas;
    }

    public void setCriaturasMagicas(List<CriaturaMagica> criaturasMagicas) {
        this.criaturasMagicas = criaturasMagicas;
    }
}