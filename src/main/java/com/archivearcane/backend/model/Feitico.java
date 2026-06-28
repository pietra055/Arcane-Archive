package com.archivearcane.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "feiticos")
public class Feitico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Elemento elemento;

    @Enumerated(EnumType.STRING)
    private TipoFeitico tipo;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private NivelDificuldade nivelDificuldade;

    @ManyToMany(mappedBy = "feiticos")
    @JsonIgnore
    private Set<Bruxo> bruxos = new HashSet<>();

    public Feitico() {
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

    public Elemento getElemento() {
        return elemento;
    }

    public void setElemento(Elemento elemento) {
        this.elemento = elemento;
    }

    public TipoFeitico getTipo() {
        return tipo;
    }

    public void setTipo(TipoFeitico tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public NivelDificuldade getNivelDificuldade() {
        return nivelDificuldade;
    }

    public void setNivelDificuldade(NivelDificuldade nivelDificuldade) {
        this.nivelDificuldade = nivelDificuldade;
    }

    public Set<Bruxo> getBruxos() {
        return bruxos;
    }

    public void setBruxos(Set<Bruxo> bruxos) {
        this.bruxos = bruxos;
    }
}