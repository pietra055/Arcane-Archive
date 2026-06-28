package com.archivearcane.backend.model;

import jakarta.persistence.*;

@Entity
@Table(
    name = "combinacoes",
    uniqueConstraints = @UniqueConstraint(columnNames = {
        "elemento1",
        "elemento2",
        "resultado"
    })
)

public class Combinacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Elemento elemento1;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Elemento elemento2;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Elemento resultado;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private NivelDificuldade nivelDificuldade;

    public Combinacao() {
    }

    public Combinacao(Long id,
                      Elemento elemento1,
                      Elemento elemento2,
                      Elemento resultado,
                      String descricao,
                      NivelDificuldade nivelDificuldade) {
        this.id = id;
        this.elemento1 = elemento1;
        this.elemento2 = elemento2;
        this.resultado = resultado;
        this.descricao = descricao;
        this.nivelDificuldade = nivelDificuldade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Elemento getElemento1() {
        return elemento1;
    }

    public void setElemento1(Elemento elemento1) {
        this.elemento1 = elemento1;
    }

    public Elemento getElemento2() {
        return elemento2;
    }

    public void setElemento2(Elemento elemento2) {
        this.elemento2 = elemento2;
    }

    public Elemento getResultado() {
        return resultado;
    }

    public void setResultado(Elemento resultado) {
        this.resultado = resultado;
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
}