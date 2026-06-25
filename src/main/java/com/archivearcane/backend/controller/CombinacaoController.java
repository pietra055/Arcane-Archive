package com.archivearcane.backend.controller;

import com.archivearcane.backend.model.Combinacao;
import com.archivearcane.backend.service.CombinacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/combinacoes")
public class CombinacaoController {

    @Autowired
    private CombinacaoService service;

    @GetMapping
    public List<Combinacao> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Combinacao buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Combinação não encontrada."));
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
}