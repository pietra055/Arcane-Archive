package com.archivearcane.backend.controller;

import com.archivearcane.backend.model.Bruxo;
import com.archivearcane.backend.service.BruxoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bruxos")
public class BruxoController {

    @Autowired
    private BruxoService service;

    // ===================== CRUD =====================

    @GetMapping
    public List<Bruxo> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Bruxo buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Bruxo não encontrado."));
    }

    @PostMapping
    public Bruxo salvar(@RequestBody Bruxo bruxo) {
        return service.salvar(bruxo);
    }

    @PutMapping("/{id}")
    public Bruxo atualizar(@PathVariable Long id, @RequestBody Bruxo bruxo) {
        return service.atualizar(id, bruxo);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    // ===================== CONSULTAS =====================

    @GetMapping("/casa/{casaId}")
    public List<Bruxo> buscarPorCasa(@PathVariable Long casaId) {
        return service.buscarPorCasa(casaId);
    }

    @GetMapping("/ano/{anoEscolar}")
    public List<Bruxo> buscarPorAnoEscolar(@PathVariable Integer anoEscolar) {
        return service.buscarPorAnoEscolar(anoEscolar);
    }

    @GetMapping("/nivel/{nivel}")
    public List<Bruxo> buscarPorNivelAprendizado(@PathVariable String nivel) {
        return service.buscarPorNivelAprendizado(nivel);
    }
}