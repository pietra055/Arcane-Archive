package com.archivearcane.backend.controller;

import com.archivearcane.backend.model.Combinacao;
import com.archivearcane.backend.model.Elemento;
import com.archivearcane.backend.service.CombinacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/combinacoes")
@CrossOrigin(origins = "*")
public class CombinacaoController {

    @Autowired
    private CombinacaoService service;

    // ===================== CRUD =====================

    @GetMapping
    public List<Combinacao> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Combinacao buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Combinacao salvar(@RequestBody Combinacao combinacao) {
        return service.salvar(combinacao);
    }

    @PutMapping("/{id}")
    public Combinacao atualizar(@PathVariable Long id,
                                @RequestBody Combinacao combinacao) {
        return service.atualizar(id, combinacao);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    // ===================== CONSULTAS =====================

    @GetMapping("/resultado/{resultado}")
    public List<Combinacao> buscarPorResultado(@PathVariable Elemento resultado) {
        return service.buscarPorResultado(resultado);
    }

    @GetMapping("/elemento1/{elemento1}")
    public List<Combinacao> buscarPorElemento1(@PathVariable Elemento elemento1) {
        return service.buscarPorElemento1(elemento1);
    }

    @GetMapping("/elemento2/{elemento2}")
    public List<Combinacao> buscarPorElemento2(@PathVariable Elemento elemento2) {
        return service.buscarPorElemento2(elemento2);
    }

    @GetMapping("/{elemento1}/{elemento2}")
    public Combinacao buscarPorElementos(@PathVariable Elemento elemento1,
                                         @PathVariable Elemento elemento2) {
        return service.buscarPorElementos(elemento1, elemento2);
    }

}