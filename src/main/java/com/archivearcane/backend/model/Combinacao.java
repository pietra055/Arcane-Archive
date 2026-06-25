package com.archivearcane.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "combinacoes")
public class Combinacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String elemento1;

    private String elemento2;

    private String resultado;

    private String descricao;

    private Integer nivelDificuldade;

    @ManyToOne
    @JoinColumn(name = "feitico_id")
    private Feitico feitico;

    public Combinacao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getElemento1() {
        return elemento1;
    }

    public void setElemento1(String elemento1) {
        this.elemento1 = elemento1;
    }

    public String getElemento2() {
        return elemento2;
    }

    public void setElemento2(String elemento2) {
        this.elemento2 = elemento2;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getNivelDificuldade() {
        return nivelDificuldade;
    }

    public void setNivelDificuldade(Integer nivelDificuldade) {
        this.nivelDificuldade = nivelDificuldade;
    }

    public Feitico getFeitico() {
        return feitico;
    }

    public void setFeitico(Feitico feitico) {
        this.feitico = feitico;
    }
}