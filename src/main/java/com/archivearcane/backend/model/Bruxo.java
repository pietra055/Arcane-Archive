package com.archivearcane.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Bruxo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer idade;
    private Integer anoEscolar;
    private String nivelAprendizadoMagia;

    @ManyToOne
    @JoinColumn(name = "casa_id")
    @JsonBackReference
    private Casa casa;

    @ManyToMany
    @JoinTable(
            name = "bruxo_feitico",
            joinColumns = @JoinColumn(name = "bruxo_id"),
            inverseJoinColumns = @JoinColumn(name = "feitico_id")
    )
    private Set<Feitico> feiticos = new HashSet<>();

    public Bruxo() {
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

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getAnoEscolar() {
        return anoEscolar;
    }

    public void setAnoEscolar(Integer anoEscolar) {
        this.anoEscolar = anoEscolar;
    }

    public String getNivelAprendizadoMagia() {
        return nivelAprendizadoMagia;
    }

    public void setNivelAprendizadoMagia(String nivelAprendizadoMagia) {
        this.nivelAprendizadoMagia = nivelAprendizadoMagia;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public Set<Feitico> getFeiticos() {
        return feiticos;
    }

    public void setFeiticos(Set<Feitico> feiticos) {
        this.feiticos = feiticos;
    }
}